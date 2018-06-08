package com.flybian.vote.facade;


import com.alibaba.fastjson.JSONObject;
import com.flybian.vote.model.UserInfoModel;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping(value="/user")
public class UserInformation
{
    @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.GET)
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("getUserInfo" );
        response.setHeader("content-type","text/json;charset=UTF-8");
        UserInfoModel user = new UserInfoModel("aaaa","bbbb",20);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.write(user.toJsonString());
        System.out.println(user.toJsonString());
    }

    @RequestMapping(value = "/setUserDetail",method = RequestMethod.PUT)
    public void setUserDetail(HttpServletRequest request,HttpServletResponse response,@RequestParam String userId)
    {
        System.out.println("setUserDetail" + userId);
    }
}
