package com.flybian.vote.datastruct.convert;

import com.flybian.util.UtilTools;
import com.flybian.vote.datastruct.dto.UserInfoDto;
import com.flybian.vote.datastruct.model.UserInfoModel;

public class UserInfoConvert {
    static public  UserInfoDto convertUserInfoModel(UserInfoModel user_model)
    {
        UserInfoDto dto = new UserInfoDto();
        dto.setId(user_model.getId().isEmpty()?UtilTools.getUUID():user_model.getId());
        dto.setUsername(user_model.getUsername());
        dto.setPassword(user_model.getPassword());
        dto.setNickname(user_model.getNickname());
        dto.setGender(user_model.getGender());
        dto.setCountry(user_model.getCountry());
        dto.setProvince(user_model.getProvince());
        dto.setCity(user_model.getCity());
        dto.setOpen_id(user_model.getOpen_id());
        dto.setAvatar_url(user_model.getAvatar_url());
        dto.setSession_key(user_model.getSession_key());
        return dto;
   }
}
