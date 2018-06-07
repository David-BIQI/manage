package com.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.common.exception.CheckException;
import com.common.exception.ServiceException;
import com.common.result.ResultCode;
import com.common.result.ResultDto;

import lombok.extern.slf4j.Slf4j;


/**
 * @author xiebq
 * spring封装的异常处理的类
 *
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)  
	public ResponseEntity<ResultDto<String>> handleException(HttpServletRequest req,Exception e) {
		ResultDto<String> ret = new ResultDto<String>();
		ResponseEntity<ResultDto<String>> httpResp = new ResponseEntity<ResultDto<String>>(ret,HttpStatus.OK);
		if(e instanceof ServiceException){
			ServiceException se = (ServiceException) e;
			ret.setCode(se.getCode());
			ret.setMsg(se.getMessage());
			log.error("接口调用服务异常，内部异常:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
		}if(e instanceof IllegalArgumentException){
			ret.setCode(ResultCode.FAIL_ILLEGALARGUMENT);
			ret.setMsg("IllegalArgumentException");
			log.error("接口调用服务异常，方法参数:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
		}if(e instanceof CheckException){
			CheckException se = (CheckException) e;
			ret.setCode(se.getCode());
			ret.setMsg(se.getMessage());
			log.error("接口调用服务异常，验证条件异常:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
		}if(e instanceof MethodArgumentTypeMismatchException){
			ret.setCode(ResultCode.FAIL_METHODARGUMENT);
			ret.setMsg("请求参数异常");
			log.error("接口调用服务异常，请求参数异常:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
		}else{
			ret.setCode(ResultCode.FAIL_UNKNOWN);
			ret.setMsg("未知异常");
			log.error("接口调用服务异常，未知异常:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
			//TODO 未知的异常，应该格外注意，可以发送邮件通知等			
		}
		return httpResp;
		
	}
}
