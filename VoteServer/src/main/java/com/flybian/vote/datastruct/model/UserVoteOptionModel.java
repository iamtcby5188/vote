package com.flybian.vote.datastruct.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class UserVoteOptionModel {
    private String id;
    private String user_vote_id;
    private String vote_option_id;
    private String vote_option;

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public List <String> getLstImage() {
        return lstImage;
    }

    public void setLstImage(List <String> lstImage) {
        this.lstImage = lstImage;
    }

    private Boolean isChecked;
    private List<String> lstImage;
    public UserVoteOptionModel() {
        id = "";
        user_vote_id = "";
        vote_option_id = "";
        vote_option = "";
    }

    public String getVote_option() {
        return vote_option;
    }

    public void setVote_option(String vote_option) {
        this.vote_option = vote_option;
    }

    public String getVote_option_id() {
        return vote_option_id;
    }

    public void setVote_option_id(String vote_option_id) {
        this.vote_option_id = vote_option_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_vote_id() {
        return user_vote_id;
    }

    public void setUser_vote_id(String user_vote_id) {
        this.user_vote_id = user_vote_id;
    }


    public JSONObject toJson()
    {
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        jo.put("user_vote_id",user_vote_id);
        jo.put("vote_option_id",vote_option_id);
        jo.put("vote_option",vote_option);
        jo.put("isChecked",isChecked);

        JSONArray ja = new JSONArray();
        for (String item : lstImage)
        {
            ja.add(item);
        }

        jo.put("image_list",ja);
        return jo;
    }
}
