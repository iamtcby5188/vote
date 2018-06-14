package com.flybian.vote.service;

import com.flybian.util.DBTools;
import com.flybian.vote.dao.UserInfoMapperDao;
import com.flybian.vote.datastruct.dto.UserInfoDto;
import org.apache.ibatis.session.SqlSession;

public class UserInformationService {
    private SqlSession session = DBTools.getSession();
    private UserInfoMapperDao user_info_dao = session.getMapper(UserInfoMapperDao.class);

    public void addNewUser(UserInfoDto user)
    {
        user_info_dao.addNewUser(user);
        session.commit();
    }

    public void modifyUser(UserInfoDto user)
    {
        user_info_dao.modifyUser(user);
        session.commit();
    }

    public UserInfoDto getUserInfoById(String id)
    {
        return  user_info_dao.getUserInfo(id);
    }

    public void weChatLogin(String code)
    {

    }
}
