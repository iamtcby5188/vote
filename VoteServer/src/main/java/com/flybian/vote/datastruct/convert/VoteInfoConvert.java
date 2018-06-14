package com.flybian.vote.datastruct.convert;

import com.flybian.util.UtilTools;
import com.flybian.vote.datastruct.dto.VoteInfoDto;
import com.flybian.vote.datastruct.dto.VoteOptionDto;
import com.flybian.vote.datastruct.model.VoteInfoModel;
import com.flybian.vote.datastruct.model.VoteOptionModel;

import java.util.List;

public class VoteInfoConvert {
    static public void convertVoteInfoModel(VoteInfoModel vote_model, VoteInfoDto vote_dto, List<VoteOptionDto> lst_option_dto){
        vote_dto.setId(vote_model.getId().isEmpty()?UtilTools.getUUID():vote_model.getId());
        vote_dto.setCreate_user(vote_model.getCreate_user());
        vote_dto.setCreate_time(vote_model.getCreate_time());
        vote_dto.setVote_type(vote_model.getVote_type());
        vote_dto.setVote_topic(vote_model.getVote_topic());
        vote_dto.setVote_description(vote_model.getVote_description());

        List<VoteOptionModel> lst = vote_model.getLst_vote_option();
        for (VoteOptionModel item:lst)
        {
            VoteOptionDto tmp_dto = new VoteOptionDto();
            tmp_dto.setId(item.getId().isEmpty()?UtilTools.getUUID():item.getId());
            tmp_dto.setVote_option(item.getVote_option());
            tmp_dto.setVote_id(vote_dto.getId());
            lst_option_dto.add(tmp_dto);
        }
    }

    static public VoteInfoModel convertVoteDto(VoteInfoDto dto,List<VoteOptionDto> lst_option_dto)
    {
        VoteInfoModel model = new VoteInfoModel();
        model.setId(dto.getId());
        model.setCreate_time(dto.getCreate_time());
        model.setCreate_user(dto.getCreate_time());
        model.setVote_type(dto.getVote_type());
        model.setVote_topic(dto.getVote_topic());
        model.setVote_description(dto.getVote_description());

        List<VoteOptionModel> lst_option = model.getLst_vote_option();
        for (VoteOptionDto item : lst_option_dto){
            VoteOptionModel tmp_model = new VoteOptionModel();
            tmp_model.setId(item.getId());
            tmp_model.setVote_option(item.getVote_option());
            tmp_model.setVote_id(item.getVote_id());
            lst_option.add(tmp_model);
        }

        return  model;
    }
}
