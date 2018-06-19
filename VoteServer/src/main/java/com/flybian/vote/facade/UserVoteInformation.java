package com.flybian.vote.facade;

import com.alibaba.fastjson.JSONArray;
import com.flybian.vote.datastruct.model.UserVoteInfoModel;
import com.flybian.vote.service.UserVoteInformationService;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping(value="/userVote")
public class UserVoteInformation {
    private UserVoteInformationService user_vote_info_service = new UserVoteInformationService();

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public void vote(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVoteInfoModel vote) {
        user_vote_info_service.vote(vote);
    }

    @RequestMapping(value = "/getAttendVote",method = RequestMethod.POST)
    public void getUserVoteByAttendUser(HttpServletRequest request,HttpServletResponse response, @RequestParam String attend_user_id)
    {
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        List<UserVoteInfoModel> lst = user_vote_info_service.getUserVoteByAttendUser(attend_user_id);
        JSONArray ja = new JSONArray();
        for (UserVoteInfoModel item:lst)
        {
            ja.add(item.toJson());
        }

        PrintWriter out = null;
        try{
            out = response.getWriter();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(ja.toString());
        out.write(ja.toString());
    }
}
