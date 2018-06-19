package com.flybian.vote.facade;

import com.alibaba.fastjson.JSONArray;
import com.flybian.vote.datastruct.model.VoteInfoModel;
import com.flybian.vote.service.VoteInformationService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping(value="/voteinfo")
public class VoteInformation {

    private VoteInformationService vote_info_service = new VoteInformationService();
    @RequestMapping(value = "/addNewVote",method = RequestMethod.POST)
    public void addNewVote(HttpServletRequest request, HttpServletResponse response, @RequestBody VoteInfoModel vote)
    {
        vote_info_service.addNewVote(vote);
    }

    @RequestMapping(value = "/getVoteInfo",method = RequestMethod.GET)
    public void getVoteInfoByUser(HttpServletRequest request, HttpServletResponse response, @RequestParam String user_id)
    {
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        List<VoteInfoModel> lst_model = vote_info_service.getVoteInfoByUser(user_id);
        JSONArray ja = new JSONArray();
        for (VoteInfoModel item : lst_model)
        {
            ja.add(item.toJson());
        }

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.write(ja.toString());
    }
}
