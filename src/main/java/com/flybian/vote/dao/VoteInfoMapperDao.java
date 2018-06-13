package com.flybian.vote.dao;

import com.flybian.vote.datastruct.dto.VoteInfoDto;
import com.flybian.vote.datastruct.dto.VoteOptionDto;

import java.util.List;

public interface VoteInfoMapperDao {
    public void addNewVote(VoteInfoDto vote);
    public void addVoteOption(List<VoteOptionDto> lstOption);
    public List<VoteInfoDto> getVoteInfo(String user_id);
    public List<VoteOptionDto> getVoteOption(String vote_id);
}
