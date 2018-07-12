package com.common.check;

import com.common.constant.ReCode;
import com.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;


/**
 * @author xiebq
 * 校验类，异常直接抛出，经过aop或者exception接收统一进行处理
 */
@Slf4j
public class CheckUtil {


	public static final int FAIL_SERVER_ERROR = ReCode.FAIL_SERVER_ERROR.getCode();


	/**
	 * 功能:检验传入对象参数-->有异常抛出请求参数异常 4300
	 * @param bindingResult
	 */
    public static void hasErrors(BindingResult bindingResult){
		StringBuilder sb = new StringBuilder();
		if(bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			errors.forEach(item->sb.append(item.getDefaultMessage()+";"));
			fail(ReCode.FAIL_PARAMETER_ERROR.getCode(),sb.toString());
		}
	};

    /**
	 * 功能:condition 不成立情况下-->msg
	 * @author xiebq 2018-05-09 16:49
	 */
	public static void check(boolean condition, String msg) {
		if (!condition) {
			fail(FAIL_SERVER_ERROR,msg);
		}
	}
	
	/** 
	 * 功能: condition 不成立情况下-->msg,retcode
	 * @author xiebq 2018-05-09 16:49
	 */
	public static void check(boolean condition,Integer retcode, String msg) {
		if (!condition) {
			fail(retcode,msg);
		}
	}

	/**
	 * 功能: 检验对象不为空和'',否则-->异常 msg
	 * @param str
	 * @param msg
	 */
	public static void notEmpty(String str, String msg) {
		if (null == str || str.isEmpty()) {
			fail(FAIL_SERVER_ERROR,msg);
		}
	}
	

	/**
	 * 功能: 检验对象不为空，为空情况-->异常 msg
	 * @param obj
	 * @param msg
	 */
	public static void notNull(Object obj, String msg) {
		if (null == obj) {
			fail(FAIL_SERVER_ERROR,msg);
		}
	}

	private static void fail(Integer retcode,String msg) {
		log.error(msg);
		throw new ServiceException(retcode, msg);
	}
	
}

