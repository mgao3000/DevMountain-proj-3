package com.javaunit3.springmvc.model;

public class MovieDto {

    private String movieTitle;

    private String maturityRating;

    private String genre;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "movieTitle='" + movieTitle + '\'' +
                ", maturityRating='" + maturityRating + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
