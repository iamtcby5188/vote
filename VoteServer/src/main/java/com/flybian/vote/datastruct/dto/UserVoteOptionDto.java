package com.flybian.vote.datastruct.dto;

public class UserVoteOptionDto {
    private String id;
    private String user_vote_id;
    private String vote_option_id;

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

    public String getVote_option_id() {
        return vote_option_id;
    }

    public void setVote_option_id(String vote_option_id) {
        this.vote_option_id = vote_option_id;
    }
}
