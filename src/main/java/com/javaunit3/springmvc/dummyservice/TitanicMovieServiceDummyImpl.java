package com.javaunit3.springmvc.dummyservice;

import com.javaunit3.springmvc.entity.MovieEntity;
import com.javaunit3.springmvc.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("titanicMovieDummyService")
public class TitanicMovieServiceDummyImpl implements MovieService {
    public String getTitle() {
        return "Titanic";
    }

    public String getMaturityRating() {
        return "PG-13";
    }

    public String getGenre() {
        return "Romance";
    }

    @Override
    public List<MovieEntity> getAllMovies() {
        return null;
    }

    @Override
    public Optional<MovieEntity> getMovieEntityById(Integer movieId) {
        return null;
    }

    @Override
    public MovieEntity saveOrUpdate(MovieEntity movieEntity) {
        return null;
    }
}