package com.javaunit3.springmvc.app;

import com.javaunit3.springmvc.model.BestMovieService;
import com.javaunit3.springmvc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan({"com.javaunit3.springmvc.model", "com.javaunit3.springmvc.dummyservice"})
//@Component
public class MovieApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MovieApp.class);

        BestMovieService bestMovieService = applicationContext.getBean("bestMovieService", BestMovieService.class);

//        MovieApp movieApp = new MovieApp();
        MovieService bestMovie = bestMovieService.getBestMovie();
//        MovieService bestMovie = movieApp.getBestMovieService().getBestMovie();

        System.out.println("Title: " + bestMovie.getTitle());
        System.out.println("Maturity Rating: " + bestMovie.getMaturityRating());
        System.out.println("Genre: " + bestMovie.getGenre());
    }
}
