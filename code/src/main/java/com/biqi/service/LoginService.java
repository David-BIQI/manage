package com.biqi.service;

import static com.common.check.CheckUtil.notNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biqi.dao.UserDao;
import com.biqi.dto.LoginDto;
import com.biqi.dto.UserDto;
import com.biqi.model.User;

import lombok.extern.slf4j.Slf4j;
/**   
 * Description: 登陆的类
 * @Package com.biqi.service 
 * @author  xiebq @date    2018年6月16日 下午5:27:11 
 */
@Service
@Slf4j
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public UserDto login(LoginDto loginDto) {
		// TODO 校验logintime sign等
		User user = User.builder()
						.name(loginDto.getName())
						.password(loginDto.getPassword())
						.build();
		user = userDao.selectOne(user);
		notNull(user, "用户名密码错误");
		UserDto userDto = UserDto.builder()
				.name(user.getName())
				.phone(user.getPhone())
//				.token("123")
				.build();
//		ThreadLocal aaLocal = new ThreadLocal<>()
		return userDto;
	}
	

}

