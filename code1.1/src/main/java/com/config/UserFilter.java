package com.config;

import com.common.exception.UnloginException;
import com.common.util.UserUtil;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
public class UserFilter {
	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public FilterRegistrationBean testFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		// 添加过滤器
		registration.setFilter(new MyFilter());
		// 设置过滤路径，/*所有路径
		registration.addUrlPatterns("/*");
		// 添加默认参数
		registration.addInitParameter("name", "alue");
		// 设置优先级
		registration.setName("MyFilter");
		// 设置优先级
		registration.setOrder(1);
		return registration;
	}

	public class MyFilter implements Filter {

		private String LOGIN_URL = "/login";

		@Override
		public void destroy() {
		}

		@Override
		public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
				throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) srequest;
			String url = request.getRequestURI();
			// Login的时候跳过，不然都进入其他
			if (LOGIN_URL.equals(url)) {
				System.out.println("这是登录的方法咯 ");
				filterChain.doFilter(srequest, sresponse);
			} else {
				HttpSession session = request.getSession(true);
				if (session == null) {
					throw new UnloginException();
				}
				// 从session中获取用户信息放到工具类中
				String userToken = (String) session.getAttribute(UserUtil.KEY_USER);
				UserUtil.setUser(userToken);
				filterChain.doFilter(srequest, sresponse);
			}
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {
		}
	}
}