package com.javaunit3.springmvc.model;

import com.javaunit3.springmvc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BestMovieService {

    private MovieService movie;

    @Autowired
    public BestMovieService(@Qualifier("titanicMovieDummyService") MovieService movie)
    {
        this.movie = movie;
    }

    public MovieService getBestMovie() {
        return movie;
    }
}
