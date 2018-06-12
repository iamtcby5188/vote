package com.flybian.vote.facade;

import com.flybian.vote.datastruct.model.VoteInfoModel;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/voteinfo")
public class VoteInformation {

    @RequestMapping(value = "/addNewVote",method = RequestMethod.POST)
    public void addNewVote(HttpServletRequest request, HttpServletResponse response, @RequestBody VoteInfoModel vote)
    {

    }

    @RequestMapping(value = "/getVoteInfo",method = RequestMethod.GET)
    public void getVoteInfoByUser(HttpServletRequest request, HttpServletResponse response, @RequestParam String user_id)
    {

    }
}
