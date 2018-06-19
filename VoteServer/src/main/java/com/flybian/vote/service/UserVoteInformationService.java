package com.flybian.vote.service;

import com.flybian.util.DBTools;
import com.flybian.vote.dao.UserVoteInfoMapperDao;
import com.flybian.vote.datastruct.convert.UserVoteConvert;
import com.flybian.vote.datastruct.dto.UserVoteInfoDto;
import com.flybian.vote.datastruct.dto.UserVoteOptionDto;
import com.flybian.vote.datastruct.model.UserVoteInfoModel;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class UserVoteInformationService {
    private SqlSession session = DBTools.getSession();
    private UserVoteInfoMapperDao user_vote_info_dao = session.getMapper(UserVoteInfoMapperDao.class);
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
        return lst_ret;
    }

}
