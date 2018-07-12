package com.common.exception;

import java.io.Serializable;

import com.common.constant.ReCode;

/**   
 * Description: 功能运行，检验条件异常
 * @Package com.common.exception 
 * @author  xiebq @date    2018年6月7日 下午8:17:51 
 */
public class CheckException extends RuntimeException implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String msg;

	public CheckException() {
		this.code = ReCode.FAIL_UNCHECK_ERROR.getCode();
	}

	public CheckException(Integer code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}

	public CheckException(Integer code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.msg = message;
	}

	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
