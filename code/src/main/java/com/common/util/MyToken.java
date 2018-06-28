package com.common.util;

import com.biqi.dto.LoginDto;

public class MyToken {

    public static String getToken(LoginDto loginDto){
        return MyMd5.getMd5(loginDto.toString());
    }

}
