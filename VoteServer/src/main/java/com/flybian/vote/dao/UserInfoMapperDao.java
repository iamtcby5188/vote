package com.flybian.vote.dao;

import com.flybian.vote.datastruct.dto.UserInfoDto;

public interface UserInfoMapperDao {
    public void addNewUser(UserInfoDto user);
    public void modifyUser(UserInfoDto user);
    public UserInfoDto getUserInfo(String id);
    public UserInfoDto getUserInfoByOpenId(String open_id);
    public String getIdByOpenID(String open_id);
    public String getImageByUserId(String user_id);
}

