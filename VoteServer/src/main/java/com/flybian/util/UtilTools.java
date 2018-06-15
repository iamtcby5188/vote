package com.flybian.util;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UtilTools {
    static SimpleDateFormat dfYYYYMMDDHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
    static public  String getUUID(){

        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }

    static public String getCurrentTimeString(){
        return  dfYYYYMMDDHHmmss.format(new Date());
    }

    static public String buildJson(String key,String value){
        JSONObject jo = new JSONObject();
        jo.put(key,value);
        return jo.toJSONString();
    }
}
