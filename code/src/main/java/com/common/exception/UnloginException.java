package com.common.exception;

import com.common.constant.ReCode;

import java.io.Serializable;

public class UnloginException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer code ;
    private String msg ;

    public UnloginException() {
        this.code = ReCode.FAIL_UNLOGIN_ERROR.getCode();
        this.msg = ReCode.FAIL_UNLOGIN_ERROR.getName();
    }

    public UnloginException(String msg) {
        this.code = ReCode.FAIL_UNLOGIN_ERROR.getCode();
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

}
