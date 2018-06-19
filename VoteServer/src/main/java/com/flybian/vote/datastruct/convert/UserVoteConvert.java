package com.flybian.vote.datastruct.convert;

import com.flybian.util.UtilTools;
import com.flybian.vote.datastruct.dto.UserVoteInfoDto;
import com.flybian.vote.datastruct.dto.UserVoteOptionDto;
import com.flybian.vote.datastruct.model.UserVoteInfoModel;
import com.flybian.vote.datastruct.model.UserVoteOptionModel;

import java.util.List;

public class UserVoteConvert {
    static public void convertUserVoteInfoModel(UserVoteInfoModel vote_model, UserVoteInfoDto vote_dto, List<UserVoteOptionDto> lst_option_dto){
        vote_dto.setId(vote_model.getId().isEmpty()?UtilTools.getUUID():vote_model.getId());
        vote_dto.setVote_id(vote_model.getVote_id());
        vote_dto.setVote_time(vote_model.getVote_time());
        vote_dto.setVote_topic(vote_model.getVote_topic());
        vote_dto.setVote_description(vote_model.getVote_description());
        vote_dto.setDead_line(vote_model.getDead_line());

        List<UserVoteOptionModel> lst = vote_model.getLst_user_vote_option();
        for (UserVoteOptionModel item:lst)
        {
            UserVoteOptionDto tmp_dto = new UserVoteOptionDto();
            tmp_dto.setId(item.getId().isEmpty()?UtilTools.getUUID():item.getId());
            tmp_dto.setUser_vote_id(vote_dto.getId());
            tmp_dto.setVote_option_id(item.getVote_option_id());
            tmp_dto.setOptions(item.getOptions());
            lst_option_dto.add(tmp_dto);
        }
    }
}
