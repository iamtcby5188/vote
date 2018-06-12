package com.flybian.vote.dao;

import com.flybian.vote.datastruct.dto.UserInfoDto;

public interface UserInfoMapperDao {

    public void addNewUser(UserInfoDto user);
    public void modifyUser(UserInfoDto user);
    public void deleteUser(String id);
    public void getUserInfo(String id);
}

