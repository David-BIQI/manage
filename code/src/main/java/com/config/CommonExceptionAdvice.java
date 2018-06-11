package com.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.common.constant.ReCode;
import com.common.exception.CheckException;
import com.common.exception.ServiceException;
import com.common.result.ResultDto;
import com.fasterxml.jackson.core.JsonParseException;

import lombok.extern.slf4j.Slf4j;


/**
 * @author xiebq
 * spring封装的异常处理的类
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
			return httpResp;
		}
		
		if(e instanceof IllegalArgumentException){
			ret.setCode(ReCode.FAIL_PARAMETER_ERROR.getCode());
			ret.setMsg(ReCode.FAIL_PARAMETER_ERROR.getName());
			log.error("接口调用服务异常，方法参数:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
			return httpResp;
		}
		
		if(e instanceof CheckException){
			CheckException se = (CheckException) e;
			ret.setCode(ReCode.FAIL_UNCHECK_ERROR.getCode());
			if (null == se.getMessage()) {
				ret.setMsg(ReCode.FAIL_UNCHECK_ERROR.getName());
			}else {
				ret.setMsg(se.getMessage());
			}
			log.error("接口调用服务异常，验证条件异常:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
			return httpResp;
		}
		
		if(e instanceof MethodArgumentTypeMismatchException){
			ret.setCode(ReCode.FAIL_PARAMETER_ERROR.getCode());
			ret.setMsg(ReCode.FAIL_PARAMETER_ERROR.getName());
			log.error("接口调用服务异常，请求参数异常:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
			return httpResp;
		}
		//不符合Json格式的错误，或者类型转换异常等
		if(e instanceof HttpMessageNotReadableException){
			ret.setCode(ReCode.FAIL_JSON_ERROR.getCode());
			ret.setMsg(ReCode.FAIL_JSON_ERROR.getName());
			log.error("接口调用服务异常，请求的Json格式异常:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
			return httpResp;
		}
		
		ret.setCode(ReCode.FAIL_UNKNOWN_ERROR.getCode());
		ret.setMsg(ReCode.FAIL_UNKNOWN_ERROR.getName());
		log.error("接口调用服务异常，未知异常:{},uri:{},query params:{}", new Object[]{e.getMessage(),req.getRequestURI(),req.getQueryString()});
		//FIXME 未知的异常，应该格外注意，可以发送邮件通知等			
		return httpResp;
		
	}
}
