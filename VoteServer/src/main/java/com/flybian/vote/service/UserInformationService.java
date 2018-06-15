package com.flybian.vote.service;

import com.flybian.util.DBTools;
import com.flybian.util.UtilTools;
import com.flybian.vote.dao.UserInfoMapperDao;
import com.flybian.vote.datastruct.convert.UserInfoConvert;
import com.flybian.vote.datastruct.dto.UserInfoDto;
import com.flybian.vote.datastruct.model.UserInfoModel;
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

    public String weChatLogin(UserInfoModel user)
    {
        UserInfoDto dto = UserInfoConvert.convertUserInfoModel(user);
        String id = user_info_dao.getIdByOpenID(dto.getOpen_id());
        System.out.println(id);
        if(id == null || id.isEmpty())
        {
            id = dto.getId();
            dto.setCreate_time(UtilTools.getCurrentTimeString());
            user_info_dao.addNewUser(dto);
            session.commit();
        }

        return  id;
    }
}
