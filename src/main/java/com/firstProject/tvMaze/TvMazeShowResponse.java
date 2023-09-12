package com.firstProject.tvMaze;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TvMazeShowResponse {
    @JsonProperty("id")
    private Long mazeShowId;
    @JsonProperty("url")
    private String mazeShowUrl;
    @JsonProperty("name")
    private String mazeShowName;

    public TvMazeShowResponse(){}

    public TvMazeShowResponse(Long mazeShowId, String mazeShowUrl, String mazeShowName) {
        this.mazeShowId = mazeShowId;
        this.mazeShowUrl = mazeShowUrl;
        this.mazeShowName = mazeShowName;
    }

    public Long getMazeShowId() {
        return mazeShowId;
    }

    public String getMazeShowUrl() {
        return mazeShowUrl;
    }

    public String getMazeShowName() {
        return mazeShowName;
    }

    public void setMazeShowId(Long mazeShowId) {
        this.mazeShowId = mazeShowId;
    }

    public void setMazeShowUrl(String mazeShowUrl) {
        this.mazeShowUrl = mazeShowUrl;
    }

    public void setMazeShowName(String mazeShowName) {
        this.mazeShowName = mazeShowName;
    }
}
