package com.flybian.vote.facade;

import com.flybian.vote.datastruct.convert.UserInfoConvert;
import com.flybian.vote.datastruct.dto.UserInfoDto;
import com.flybian.vote.datastruct.model.UserInfoModel;
import com.flybian.vote.service.UserInformationService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/user")
public class UserInformation
{
    private UserInformationService user_info_service = new UserInformationService();

    @RequestMapping(value = "/addNewUser",method = RequestMethod.POST)
    public void addNewUser(HttpServletRequest request,HttpServletResponse response,@RequestBody UserInfoModel user)
    {
        System.out.println(user);
       UserInfoDto userinfo = UserInfoConvert.convertUserInfoModel(user);
        user_info_service.addNewUser(userinfo);
    }

    @RequestMapping(value = "/modifyUser",method = RequestMethod.POST)
    public void modifyUser(HttpServletRequest request,HttpServletResponse response,@RequestBody UserInfoModel user)
    {
        System.out.println(user);
        UserInfoDto userinfo = UserInfoConvert.convertUserInfoModel(user);
        user_info_service.modifyUser(userinfo);
    }
}
