package com.common.result;

import com.common.constant.ReCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xiebq
 *
 * @param <T>
 */
@AllArgsConstructor
@Builder
@Data
@ToString
public class ResultDto<T> {

	private Integer code;
	private String msg;
	private T data;
	private String reqId;
	
	
	public ResultDto() {
		super();
		this.code = ReCode.SUCCESS.getCode();
		this.msg = ResultMsg.SUCCESS;
	}
	
	public static ResultDto<Object> success(Object data){
		return new ResultDto<Object>(ReCode.SUCCESS.getCode(),null,data,null);
	}
	
	public static ResultDto<Object> failDefault(String message){
		return new ResultDto<Object>(ReCode.FAIL_UNKNOWN_ERROR.getCode(),message,null,null);
	}
	
	public static ResultDto<Object> failCode(String message,int resultCode){
		return new ResultDto<Object>(resultCode,message,null,null);
	}


}
