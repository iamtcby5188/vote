package com.flybian.vote.service;

import com.flybian.util.DBTools;
import com.flybian.vote.dao.UserVoteInfoMapperDao;
import com.flybian.vote.dao.VoteInfoMapperDao;
import com.flybian.vote.datastruct.convert.UserVoteConvert;
import com.flybian.vote.datastruct.dto.UserVoteInfoDto;
import com.flybian.vote.datastruct.dto.UserVoteOptionDto;
import com.flybian.vote.datastruct.dto.VoteInfoDto;
import com.flybian.vote.datastruct.model.UserVoteInfoModel;
import com.flybian.vote.datastruct.model.UserVoteOptionModel;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class UserVoteInformationService {
    private SqlSession session = DBTools.getSession();
    private UserVoteInfoMapperDao user_vote_info_dao = session.getMapper(UserVoteInfoMapperDao.class);
    private VoteInfoMapperDao vote_info_dao = session.getMapper(VoteInfoMapperDao.class);
    public  void vote(UserVoteInfoModel user_vote){
        UserVoteInfoDto dto = new UserVoteInfoDto ();
        List<UserVoteOptionDto> lst = new ArrayList<>();
        UserVoteConvert.convertUserVoteInfoModel(user_vote,dto,lst);
        user_vote_info_dao.addUserVote(dto);
        user_vote_info_dao.addUserOptions(lst);
        session.commit();
    }

    public List<UserVoteInfoModel> getUserVoteByAttendUser(String attend_user_id)
    {
        List<UserVoteInfoModel> lst_ret = new ArrayList <>();
        List<UserVoteInfoDto> lst = user_vote_info_dao.getUserVoteInfoByAttendId(attend_user_id);
        for (UserVoteInfoDto item : lst)
        {
            List<UserVoteOptionDto> lst_option = user_vote_info_dao.getUserVoteOptionsByid(item.getId());
            lst_ret.add(UserVoteConvert.convertUserVoteDto(item,lst_option));
        }

        for (UserVoteInfoModel model_item : lst_ret){
            List<VoteInfoDto> dtolst = vote_info_dao.getVoteInfoById(model_item.getVote_id());
            if (dtolst.size() > 0){
                VoteInfoDto dto = dtolst.get(0);
                model_item.setVote_topic(dto.getVote_topic());
                model_item.setVote_description(dto.getVote_description());

                List<UserVoteOptionModel> option_lst = model_item.getOption_list();
                for (UserVoteOptionModel option_model : option_lst){
                    option_model. setVote_option(vote_info_dao.getVoteOptionStringById(option_model.getVote_option_id()));
                }
            }
        }
        return lst_ret;
    }

}
