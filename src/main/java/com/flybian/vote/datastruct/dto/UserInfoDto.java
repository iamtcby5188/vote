package com.flybian.vote.datastruct.dto;

import com.alibaba.fastjson.JSONObject;

public class UserInfoDto {
    private String id;
    private String username;
    private String nickname;
    private String password;
    private String birthday;
    private int age;
    private String mobile;
    private String email;
    private int status;
    private String create_time;
    private String create_type;
    private String modify_time;

    @Override
    public  String toString()
    {
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        jo.put("username",username);
        jo.put("nickname",nickname);
        jo.put("age",age);
        jo.put("birthday",birthday);
        jo.put("mobile",mobile);
        jo.put("email",email);
        return  jo.toJSONString();
    }

    public UserInfoDto() {
    }

    public UserInfoDto(String id, String username, String nickname, String password, String birthday, int age, String mobile, String email, String create_time, String create_type) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
        this.create_time = create_time;
        this.create_type = create_type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getCreate_type() {

        return create_type;
    }

    public String getModify_time() {
        return modify_time;
    }

    public String getId() {

        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
}
