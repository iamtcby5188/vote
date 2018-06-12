package com.flybian.vote.datastruct.convert;

import com.flybian.util.UtilTools;
import com.flybian.vote.datastruct.dto.UserInfoDto;
import com.flybian.vote.datastruct.model.UserInfoModel;

public class UserInfoConvert {
    static public  UserInfoDto convertUserInfoModel(UserInfoModel user_model)
    {
        UserInfoDto dto = new UserInfoDto(user_model.getId(),user_model.getUsername(),user_model.getNickname(),user_model.getPassword(),user_model.getBirthday()
        ,user_model.getAge(),user_model.getMobile(),user_model.getEmail(),UtilTools.getCurrentTimeString(),user_model.getCreate_type());

        if (dto.getId().isEmpty()){
            dto.setId(UtilTools.getUUID());
        }
        return  dto;
    }
}
