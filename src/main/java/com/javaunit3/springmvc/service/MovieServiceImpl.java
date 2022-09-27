package com.javaunit3.springmvc.service;

import com.javaunit3.springmvc.entity.MovieEntity;
import com.javaunit3.springmvc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getMaturityRating() {
        return null;
    }

    @Override
    public String getGenre() {
        return null;
    }

    @Override
    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<MovieEntity> getMovieEntityById(Integer movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public MovieEntity saveOrUpdate(MovieEntity movieEntity) {
        return null;
    }
}
