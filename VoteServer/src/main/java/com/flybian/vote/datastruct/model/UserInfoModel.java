package com.flybian.vote.datastruct.model;

import com.alibaba.fastjson.JSONObject;

public class UserInfoModel {
    private String id;
    private String username;
    private String nickname;
    private String birthday;
    private String password;
    private int age;
    private String mobile;
    private String email;
    private int status ;
    private String create_type;

    public String getId() {
        return id == null?"":id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreate_type() {
        return create_type;
    }

    public void setCreate_type(String create_type) {
        this.create_type = create_type;
    }


    public  JSONObject toJson()
    {
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        jo.put("username",username);
        jo.put("nickname",nickname);
        jo.put("age",age);
        jo.put("birthday",birthday);
        jo.put("mobile",mobile);
        jo.put("email",email);
        return  jo;
    }
}
