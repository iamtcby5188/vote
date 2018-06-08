package com.flybian.vote.dao;

import com.flybian.vote.model.UserInfoModel;

public interface UserInfoMapperDao {
    public void save(UserInfoModel user) throws Exception;

    public void update(UserInfoModel user) throws Exception;

    public void delete(String id) throws Exception;
}

