package com.javaunit3.springmvc.service;

import com.javaunit3.springmvc.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    public String getTitle();

    public String getMaturityRating();

    public String getGenre();

    public List<MovieEntity> getAllMovies();

    public Optional<MovieEntity> getMovieEntityById(Integer movieId);

    public MovieEntity saveOrUpdate(MovieEntity movieEntity);
}
