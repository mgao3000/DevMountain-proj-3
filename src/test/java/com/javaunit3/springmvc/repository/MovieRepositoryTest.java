package com.javaunit3.springmvc.repository;

import com.javaunit3.springmvc.entity.MovieEntity;
import com.javaunit3.springmvc.entity.VoteEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private MovieEntity movieEntity;

    @BeforeEach
    public void setupEach() {
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        movieEntity = new MovieEntity();
        movieEntity.setGenre("genre_" + randomInt);
        movieEntity.setMaturityRating("Rating_" + randomInt);
        movieEntity.setTitle("title_" + randomInt);
        List<VoteEntity> voteList = new ArrayList<>();
        movieEntity.setVotes(voteList);
    }

    @AfterEach
    public void teardownEach() {

    }

    @Test
    public void testMovieRepositorySave() {
        MovieEntity savedMovieEntity = movieRepository.save(movieEntity);
        System.out.println(savedMovieEntity);

    }
}
