package com.flybian.vote.datastruct.dto;

public class UserVoteInfoDto {
    private String id;
    private String vote_id;
    private String vote_time;
    private String user_id;

    public UserVoteInfoDto() {
        id = "";
        vote_id = "";
        vote_time = "";
        user_id = "";
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
