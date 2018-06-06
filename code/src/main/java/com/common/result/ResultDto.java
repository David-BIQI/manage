package com.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class ResultDto<T> {

	private Integer code;
	private String msg;
	private T data;
	private String reqId;
	
	public static ResultDto<Object> success(Object data){
		return new ResultDto<Object>(ResultCode.SUCCESS,null,data,null);
	}
	
	public static ResultDto<Object> failDefault(String message){
		return new ResultDto<Object>(ResultCode.FAIL,message,null,null);
	}
	
	public static ResultDto<Object> failCode(String message,int resultCode){
		return new ResultDto<Object>(resultCode,message,null,null);
	}

}
