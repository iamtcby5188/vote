package com.flybian.vote.dao;

import com.flybian.vote.datastruct.dto.UserVoteInfoDto;
import com.flybian.vote.datastruct.dto.UserVoteOptionDto;

import java.util.List;

public interface UserVoteInfoMapperDao {
    public void addUserVote(UserVoteInfoDto vote);
    public void addUserOptions(List<UserVoteOptionDto> lstOption);
    public List<UserVoteInfoDto> getUserVoteInfoByAttendId(String attend_id);
    public List<UserVoteOptionDto> getUserVoteOptionsByid(String user_vote_id);
    public UserVoteOptionDto getUserVoteOptions(String user_vote_id,String vote_option_id);
    public List<String> getUserVoteIdByOptionsid(String option_id);
    public String getUserIdByUserVoteId(String user_vote_id);
}
