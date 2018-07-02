package com.flybian.vote.service;

import com.flybian.util.DBTools;
import com.flybian.vote.dao.UserInfoMapperDao;
import com.flybian.vote.dao.UserVoteInfoMapperDao;
import com.flybian.vote.dao.VoteInfoMapperDao;
import com.flybian.vote.datastruct.convert.UserVoteConvert;
import com.flybian.vote.datastruct.dto.UserVoteInfoDto;
import com.flybian.vote.datastruct.dto.UserVoteOptionDto;
import com.flybian.vote.datastruct.dto.VoteInfoDto;
import com.flybian.vote.datastruct.dto.VoteOptionDto;
import com.flybian.vote.datastruct.model.UserVoteInfoModel;
import com.flybian.vote.datastruct.model.UserVoteOptionModel;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class UserVoteInformationService {
    private SqlSession session = DBTools.getSession();
    private UserVoteInfoMapperDao user_vote_info_dao = session.getMapper(UserVoteInfoMapperDao.class);
    private VoteInfoMapperDao vote_info_dao = session.getMapper(VoteInfoMapperDao.class);
    private UserInfoMapperDao user_info_dao = session.getMapper(UserInfoMapperDao.class);
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
            UserVoteInfoModel model = new UserVoteInfoModel();
            List<VoteInfoDto> lst_vote_dto = vote_info_dao.getVoteInfoById(item.getVote_id());
            if (lst_vote_dto.size() > 0) {
                VoteInfoDto vote_dto = lst_vote_dto.get(0);
                model.setId(item.getId());
                model.setVote_id(item.getVote_id());
                model.setVote_time(item.getVote_time());
                model.setUser_id(item.getUser_id());
                model.setVote_topic(vote_dto.getVote_topic());
                model.setVote_description(vote_dto.getVote_description());

                List <VoteOptionDto> lst_vote_option = vote_info_dao.getVoteOption(item.getVote_id());

                List <UserVoteOptionModel> lst_user_option = new ArrayList <>();
                for (VoteOptionDto option_item : lst_vote_option) {
                    UserVoteOptionModel option_model = new UserVoteOptionModel();
                    option_model.setUser_vote_id(item.getId());
                    option_model.setVote_option(option_item.getVote_option());
                    option_model.setVote_option_id(option_item.getId());

                    UserVoteOptionDto user_model_dto = user_vote_info_dao.getUserVoteOptions(item.getId(),option_item.getId());
                    if (user_model_dto != null){
                        option_model.setChecked(false);
                    }
                    else
                    {
                        option_model.setChecked(true);
                    }

                    List<String> lstUser_vote = user_vote_info_dao.getUserVoteIdByOptionsid(option_item.getId());
                    List<String> lstImgage = new ArrayList <>();
                    if(lstUser_vote != null && lstUser_vote.size() > 0){
                        for (String user_vote_item : lstUser_vote){
                            String user_id = user_vote_info_dao.getUserIdByUserVoteId(user_vote_item);
                            if(user_id != null){
                                String image = user_info_dao.getImageByUserId(user_id);
                                if (image != null)
                                {
                                    lstImgage.add(image);
                                }
                            }
                        }
                    }
                    if (!lstImgage.isEmpty()){
                        option_model.setLstImage(lstImgage);
                    }
                    lst_user_option.add(option_model);
                }

                model.setLst_user_vote_option(lst_user_option);
                lst_ret.add(model);
            }
        }
        return lst_ret;
    }

}
