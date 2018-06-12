package com.flybian.util;

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
}
