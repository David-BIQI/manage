package com.common.constant;

/**   
 * Description: 返回码产量类
 * @Package com.common.constant 
 * @author  xiebq @date    2018年6月10日 下午6:04:11 
 */
public enum ReCode {
	
	/**
	 * "成功",0
	 */
	SUCCESS("成功",0),
	/**
	 * "未知错误",-1
	 */
	FAIL_UNKNOWN_ERROR("未知错误异常",-1),
	/**
	 * "没有登陆",4000
	 */
	FAIL_UNLOGIN_ERROR("没有登陆异常",4000),
	/**
	 * "服务内部异常",4100
	 */
	FAIL_SERVER_ERROR("服务内部异常",4100),
	/**
	 * "条件校验异常",4200
	 */
	FAIL_UNCHECK_ERROR("运行条件校验异常",4200),
	/**
	 * "请求参数类型异常",4300
	 */
	FAIL_PARAMETER_ERROR("请求参数异常",4300),
	/**
	 * "请求参数格式异常,可能json格式异常",4301
	 */
	FAIL_JSON_ERROR("请求参数格式异常,可能json格式异常",4301);
	
	private String name;
	
	private int code;

	private ReCode(String codeNmae, int code) {
		this.name = codeNmae;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	
	

}
