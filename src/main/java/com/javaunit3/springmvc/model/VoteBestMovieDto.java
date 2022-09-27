package com.javaunit3.springmvc.model;

public class VoteBestMovieDto {

    private Integer movieId;

    private String voterName;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    @Override
    public String toString() {
        return "VoteBestMovieDto{" +
                "movieId='" + movieId + '\'' +
                ", voterName='" + voterName + '\'' +
                '}';
    }
}
