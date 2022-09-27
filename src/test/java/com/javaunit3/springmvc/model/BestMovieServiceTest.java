package com.javaunit3.springmvc.model;

import com.javaunit3.springmvc.service.MovieService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {SampleConfiguration.class})
@SpringBootTest
public class BestMovieServiceTest {

    @Autowired
    private BestMovieService bestMovieService;

    @BeforeAll
    public static void setupOnce() {

    }

    @AfterAll
    public static void teardownOnce() {

    }

    @BeforeEach
    public void setupEach() {

    }

    @AfterEach
    public void teardownEach() {
        bestMovieService = null;
    }

    @Test
    public void testGettingBestMovieThroughBestMovieService() {
        MovieService bestMovie = bestMovieService.getBestMovie();
//        MovieService bestMovie = movieApp.getBestMovieService().getBestMovie();

        System.out.println("Title: " + bestMovie.getTitle());
        System.out.println("Maturity Rating: " + bestMovie.getMaturityRating());
        System.out.println("Genre: " + bestMovie.getGenre());
    }
}