package com.flybian.vote.datastruct.dto;

public class VoteOptionDto {
    private String id;
    private String vote_option;
    private String vote_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVote_option() {
        return vote_option;
    }

    public void setVote_option(String option) {
        this.vote_option = option;
    }

    public String getVote_id() {
        return vote_id;
    }

    public void setVote_id(String vote_id) {
        this.vote_id = vote_id;
    }
}
