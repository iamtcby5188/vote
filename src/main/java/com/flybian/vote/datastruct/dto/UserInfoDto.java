package com.flybian.vote.datastruct.dto;

public class UserInfoDto {
    private String id;
    private String username;
    private String nickname;
    private String password;
    private String birthday;
    private int age;
    private String mobile;

    public UserInfoDto(String id, String username, String nickname, String password, String birthday, int age, String mobile, String email) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
    }

    public UserInfoDto(String username, String nickname, String password, String birthday, int age, String mobile, String email) {

        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
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

    private String email;
    private int status;
}
