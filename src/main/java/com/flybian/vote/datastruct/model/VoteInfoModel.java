package com.flybian.vote.datastruct.model;

import java.util.List;

public class VoteInfoModel {
    private String id;
    private String create_user;
    private String create_time;
    private int vote_type;
    private String vote_topic;
    private String vote_description;
    private List<VoteOptionModel> lst_vote_option;
}
