package com.flybian.vote.datastruct.model;

import com.alibaba.fastjson.JSONObject;
import com.flybian.util.Constant;

public class UserInfoModel {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private int gender;
    private String country;
    private String province;
    private String city;
    private String open_id;
    private String avatar_url;
    private String session_key;

    public UserInfoModel() {
        this.id = "";
        this.username="";
        this.password = "";
        this.nickname="";
        this.gender = Constant.GENDER_MALE;
        this.country = "";
        this.province = "";
        this.city ="";
        this.open_id = "";
        this.avatar_url = "";
        this.session_key = "";
    }

    public  JSONObject toJson()
    {
        JSONObject jo = new JSONObject();
        jo.put("id",this.id);
        jo.put("username",this.username);
        jo.put("nickname",this.nickname);
        jo.put("gender",this.gender);
        jo.put("country",this.country);
        jo.put("province",this.province);
        jo.put("city",this.city);
        jo.put("avatar_url",this.avatar_url);
        jo.put("session_key" ,this.session_key);
        jo.put("open_id",this.open_id);
        return  jo;
    }

    @Override
    public String toString() {
        return toJson().toJSONString();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}
