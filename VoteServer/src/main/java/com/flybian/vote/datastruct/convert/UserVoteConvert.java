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
        vote_dto.setVote_time(vote_model.getVote_time().isEmpty()? UtilTools.getCurrentTimeString():vote_model.getVote_time());
        vote_dto.setUser_id(vote_model.getUser_id());

        List<UserVoteOptionModel> lst = vote_model.getOption_list();
        for (UserVoteOptionModel item:lst)
        {
            UserVoteOptionDto tmp_dto = new UserVoteOptionDto();
            tmp_dto.setId(item.getId().isEmpty()?UtilTools.getUUID():item.getId());
            tmp_dto.setUser_vote_id(vote_dto.getId());
            tmp_dto.setVote_option_id(item.getVote_option_id());
            lst_option_dto.add(tmp_dto);
        }
    }

    static public UserVoteInfoModel convertUserVoteDto(UserVoteInfoDto dto ,List<UserVoteOptionDto> lst_option_dto)
    {
        UserVoteInfoModel model = new UserVoteInfoModel();
        model.setId(dto.getId());
        model.setVote_id(dto.getVote_id());
        model.setVote_time(dto.getVote_time());
        model.setUser_id(dto.getUser_id());

        List<UserVoteOptionModel> lst_option = model.getOption_list();
        for (UserVoteOptionDto item : lst_option_dto)
        {
            UserVoteOptionModel tmp_model = new UserVoteOptionModel();
            tmp_model.setId(item.getId());
            tmp_model.setUser_vote_id(item.getUser_vote_id());
            tmp_model.setVote_option_id(item.getVote_option_id());
            lst_option.add(tmp_model);
        }

        return  model;
    }
}
