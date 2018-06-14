package com.flybian.vote.datastruct.model;

import com.alibaba.fastjson.JSONObject;

public class VoteOptionModel {
    private String id;
    private String vote_option;
    private String vote_id;

    public String getId() {
        return id == null?"":id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVote_option() {
        return vote_option;
    }

    public void setVote_option(String option) {
        this.vote_option= option;
    }

    public String getVote_id() {
        return vote_id;
    }

    public void setVote_id(String vote_id) {
        this.vote_id = vote_id;
    }

    public JSONObject toJson()
    {
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        jo.put("vote_option",vote_option);
        jo.put("vote_id",vote_id);

        return  jo;
    }
}
