package com.flybian.vote.datastruct.model;

import com.alibaba.fastjson.JSONObject;

public class VoteOptionModel {
    private String id;
    private String option;
    private String vote_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getVote_id() {
        return vote_id;
    }

    public void setVote_id(String vote_id) {
        this.vote_id = vote_id;
    }

    @Override
    public String toString()
    {
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        jo.put("option",id);
        jo.put("vote_id",vote_id);

        return  jo.toJSONString();
    }
}
