package com.flybian.vote.service;

import com.flybian.util.DBTools;
import com.flybian.util.UtilTools;
import com.flybian.vote.dao.VoteInfoMapperDao;
import com.flybian.vote.datastruct.convert.VoteInfoConvert;
import com.flybian.vote.datastruct.dto.VoteInfoDto;
import com.flybian.vote.datastruct.dto.VoteOptionDto;
import com.flybian.vote.datastruct.model.VoteInfoModel;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class VoteInformationService {
    private SqlSession session = DBTools.getSession();
    private VoteInfoMapperDao vote_info_dao = session.getMapper(VoteInfoMapperDao.class);

    public void addNewVote(VoteInfoModel vote)
    {
        VoteInfoDto dto = new VoteInfoDto();
        List<VoteOptionDto> lst = new ArrayList<>();
        VoteInfoConvert.convertVoteInfoModel(vote,dto,lst);
        dto.setCreate_time(UtilTools.getCurrentTimeString());
        vote_info_dao.addNewVote(dto);
        if(!lst.isEmpty()) {
            vote_info_dao.addVoteOption(lst);
        }
        session.commit();
    }

    public List<VoteInfoModel> getVoteInfoByUser(String user_id)
    {
        List<VoteInfoModel> lst_model = new ArrayList <>();
        List<VoteInfoDto> lst=  vote_info_dao.getVoteInfo(user_id);
        for (VoteInfoDto item : lst)
        {
            List<VoteOptionDto> lst_option = vote_info_dao.getVoteOption(item.getId());
            lst_model.add(VoteInfoConvert.convertVoteDto(item,lst_option));
        }

        return  lst_model;
    }
}
