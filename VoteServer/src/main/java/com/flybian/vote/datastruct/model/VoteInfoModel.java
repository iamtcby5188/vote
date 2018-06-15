package com.flybian.vote.datastruct.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VoteInfoModel {
    private String id;
    private String create_user;
    private String create_time;
    private int vote_type;
    private String vote_topic;
    private String vote_description;
    private String dead_line;
    private List<VoteOptionModel> lst_vote_option;

    public VoteInfoModel() {
        id = "";
        create_user="";
        create_time= "";
        vote_topic ="";
        vote_description="";
        vote_type=1;
        dead_line="";
        lst_vote_option = new ArrayList <>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getVote_type() {
        return vote_type;
    }

    public void setVote_type(int vote_type) {
        this.vote_type = vote_type;
    }

    public String getVote_topic() {
        return vote_topic;
    }

    public void setVote_topic(String vote_topic) {
        this.vote_topic = vote_topic;
    }

    public String getVote_description() {
        return vote_description;
    }

    public void setVote_description(String vote_description) {
        this.vote_description = vote_description;
    }

    public List <VoteOptionModel> getLst_vote_option() {
        return lst_vote_option;
    }

    public void setLst_vote_option(List <VoteOptionModel> lst_vote_option) {
        this.lst_vote_option = lst_vote_option;
    }

    public String getDead_line() {
        return dead_line;
    }

    public void setDead_line(String dead_line) {
        this.dead_line = dead_line;
    }

    public JSONObject toJson()
    {
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        jo.put("create_user",create_user);
        jo.put("create_time",create_time);
        jo.put("vote_type",vote_type);
        jo.put("vote_topic",vote_topic);
        jo.put("vote_description",vote_description);

        JSONArray ja = new JSONArray();
        for (VoteOptionModel item:lst_vote_option)
        {
            ja.add(item.toJson());
        }
        jo.put("option_list",ja);

        return  jo;
    }
}
