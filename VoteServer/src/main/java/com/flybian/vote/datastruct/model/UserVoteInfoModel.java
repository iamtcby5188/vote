package com.flybian.vote.datastruct.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserVoteInfoModel {
    private String id;
    private String vote_id;
    private String vote_time;
    private String user_id;
    private String vote_topic;
    private String vote_description;
    private int vote_type;

    public int getVote_type() {
        return vote_type;
    }

    public void setVote_type(int vote_type) {
        this.vote_type = vote_type;
    }

    public List <UserVoteOptionModel> getLst_user_vote_option() {
        return lst_user_vote_option;
    }

    public void setLst_user_vote_option(List <UserVoteOptionModel> lst_user_vote_option) {
        this.lst_user_vote_option = lst_user_vote_option;
    }

    private List<UserVoteOptionModel> lst_user_vote_option;

    public UserVoteInfoModel() {
        id = "";
        vote_id = "";
        vote_time = "";
        user_id = "";
        vote_topic = "";
        vote_description = "";
        lst_user_vote_option = new ArrayList <>();
    }

    public String getVote_description() {
        return vote_description;
    }

    public void setVote_description(String vote_description) {
        this.vote_description = vote_description;
    }

    public String getVote_topic() {
        return vote_topic;
    }

    public void setVote_topic(String vote_topic) {
        this.vote_topic = vote_topic;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVote_id() {
        return vote_id;
    }

    public void setVote_id(String vote_id) {
        this.vote_id = vote_id;
    }

    public String getVote_time() {
        return vote_time;
    }

    public void setVote_time(String vote_time) {
        this.vote_time = vote_time;
    }

    public JSONObject toJson()
    {
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        jo.put("vote_id",vote_id);
        jo.put("vote_time",vote_time);
        jo.put("user_id",user_id);
        jo.put("vote_topic",vote_topic);
        jo.put("vote_description",vote_description);
        jo.put("vote_type",vote_type);

        JSONArray ja = new JSONArray();
        for (UserVoteOptionModel item : lst_user_vote_option)
        {
            ja.add(item.toJson());
        }

        jo.put("option_list",ja);
        return jo;
    }
}
