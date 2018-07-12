package com.common.exception;

import java.io.Serializable;

import com.common.constant.ReCode;

/**   
 * Description: Service运行时候异常
 * @Package com.common.exception 
 * @author  xiebq @date    2018年6月7日 下午8:11:52 
 */
public class ServiceException extends RuntimeException implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String msg;

	public ServiceException() {
		this.code = ReCode.FAIL_SERVER_ERROR.getCode();
	}

	public ServiceException(Integer code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}

	public ServiceException(Integer code, String message, Throwable cause) {
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
