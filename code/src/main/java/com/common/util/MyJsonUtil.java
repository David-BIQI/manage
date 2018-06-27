package com.common.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * 说明：解耦需要，项目中将不直接引导第三方架包 简单的Demo
 *
 */
@Slf4j
public class MyJsonUtil {

    public static String objectToJsonString(Object object){
        if (null == object){
            return "";
        }

        JSONObject json = JSONObject.fromObject(object);
        String strJson=json.toString();
        log.debug("对象：{}",object);
        log.debug("转成String：{}",strJson);
        return strJson;
    }







}
