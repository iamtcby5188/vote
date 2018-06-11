package com.flybian.vote.datastruct.model;

import com.alibaba.fastjson.JSONObject;

public class UserInfoModel {
    private String id;
    private String userName;
    private int    age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserInfoModel(String id,String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public  String toJsonString()
    {
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        jo.put("name",userName);
        jo.put("age",age);
        return  jo.toJSONString();
    }
}
