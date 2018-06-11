package com.flybian.util;

import java.util.UUID;

public class UtilTools {
    static public  String getUUID(){

        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
}
