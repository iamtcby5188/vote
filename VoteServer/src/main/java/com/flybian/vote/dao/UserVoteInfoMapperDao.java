package com.flybian.vote.dao;

import com.flybian.vote.datastruct.dto.UserVoteInfoDto;
import com.flybian.vote.datastruct.dto.UserVoteOptionDto;

import java.util.List;

public interface UserVoteInfoMapperDao {
    public void addUserVote(UserVoteInfoDto vote);
    public void addUserOptions(List<UserVoteOptionDto> lstOption);
}
