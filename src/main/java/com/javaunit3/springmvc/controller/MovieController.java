package com.javaunit3.springmvc.controller;

import com.javaunit3.springmvc.model.BestMovieService;
import com.javaunit3.springmvc.entity.MovieEntity;
import com.javaunit3.springmvc.entity.VoteEntity;
import com.javaunit3.springmvc.model.MovieDto;
import com.javaunit3.springmvc.model.VoteBestMovieDto;
import com.javaunit3.springmvc.service.MovieService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MovieController
{
    @Autowired
    private BestMovieService bestMovieService;

    @Autowired
    @Qualifier("movieService")
    private MovieService movieService;

//    @Autowired
//    private SessionFactory sessionFactory;

    @GetMapping("/")
    public String getIndexPage()
    {
        return "index";
    }

    @GetMapping("/bestMovie")
    public String getBestMoviePage(Model model)
    {
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();

//        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
        List<MovieEntity> movieEntityList = movieService.getAllMovies();
        movieEntityList.sort(Comparator.comparing(movieEntity -> movieEntity.getVotes().size()));

        MovieEntity movieWithMostVotes = movieEntityList.get(movieEntityList.size() - 1);
        List<String> voterNames = new ArrayList<>();

        for (VoteEntity vote: movieWithMostVotes.getVotes())
        {
            voterNames.add(vote.getVoterName());
        }

        String voterNamesList = String.join(",", voterNames);

        model.addAttribute("bestMovie", movieWithMostVotes.getTitle());
        model.addAttribute("bestMovieVoters", voterNamesList);

//        session.getTransaction().commit();

        return "bestMovie";
    }

    @GetMapping("/voteForBestMovieForm")
    public String voteForBestMovieFormPage(Model model)
    {
//        Session session = sessionFactory.getCurrentSession();

//        session.beginTransaction();

//        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
        List<MovieEntity> movieEntityList = movieService.getAllMovies();

//        session.getTransaction().commit();

        model.addAttribute("movies", movieEntityList);

//        return "voteBestMovie";
        return "voteForBestMovie";
    }

//    @RequestMapping("/voteForBestMovie")
//    public String voteForBestMovie(HttpServletRequest request, Model model)
//    {
//        String movieId = request.getParameter("movieId");
//        String voterName = request.getParameter("voterName");
//
//        Session session = sessionFactory.getCurrentSession();
//
//        session.beginTransaction();
//
//        MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
//        VoteEntity newVote = new VoteEntity();
//        newVote.setVoterName(voterName);
//        movieEntity.addVote(newVote);
//
//        session.update(movieEntity);
//
//        session.getTransaction().commit();
//
//        return "voteForBestMovie";
//    }

    @RequestMapping(value = "/voteForBestMovie", method = {RequestMethod.PUT, RequestMethod.GET})
    @Transactional
    public String voteForBestMovie(VoteBestMovieDto voteBestMovieDto, Model model) {
//        String movieId = request.getParameter("movieId");
//        String voterName = request.getParameter("voterName");
        Integer movieId = voteBestMovieDto.getMovieId();
        String voterName = voteBestMovieDto.getVoterName();
        System.out.println("================= input voteBestMovieDto.movieId=" + movieId);
        System.out.println("================= input voteBestMovieDto.voterName=" + voterName);
//        Session session = sessionFactory.getCurrentSession();

//        session.beginTransaction();

//        MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
        Optional<MovieEntity> movieEntityOptional = movieService.getMovieEntityById(movieId);
        if(movieEntityOptional.isPresent()) {
            MovieEntity movieEntity = movieEntityOptional.get();
            VoteEntity newVote = new VoteEntity();
            newVote.setVoterName(voterName);
            movieEntity.addVote(newVote);

            movieService.saveOrUpdate(movieEntity);
        }
        List<MovieEntity> movieEntityList = movieService.getAllMovies();
        model.addAttribute("movies", movieEntityList);

        return "voteForBestMovie";
    }


//    @RequestMapping("/addMovieForm")
    @GetMapping("/addMovieForm")
    public String addMovieForm()
    {
        return "addMovie";
    }

//    @RequestMapping("/addMovie")
//    public String addMovie(HttpServletRequest request)
//    {
//        String movieTitle = request.getParameter("movieTitle");
//        String maturityRating = request.getParameter("maturityRating");
//        String genre = request.getParameter("genre");
//
//        MovieEntity movieEntity = new MovieEntity();
//        movieEntity.setTitle(movieTitle);
//        movieEntity.setMaturityRating(maturityRating);
//        movieEntity.setGenre(genre);
//
//        Session session = sessionFactory.getCurrentSession();
//
//        session.beginTransaction();
//
//        session.save(movieEntity);
//
//        session.getTransaction().commit();
//
//        return "addMovie";
//    }

    @PostMapping(value = "/addMovie", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String addMovie(MovieDto movieDto)
    {
//        String movieTitle = request.getParameter("movieTitle");
//        String maturityRating = request.getParameter("maturityRating");
//        String genre = request.getParameter("genre");
        System.out.println("================== movieDto=" + movieDto);
        MovieEntity movieEntity = new MovieEntity();
//        movieEntity.setTitle(movieTitle);
//        movieEntity.setMaturityRating(maturityRating);
//        movieEntity.setGenre(genre);
        movieEntity.setTitle(movieDto.getMovieTitle());
        movieEntity.setMaturityRating(movieDto.getMaturityRating());
        movieEntity.setGenre(movieDto.getGenre());

//        Session session = sessionFactory.getCurrentSession();

//        session.beginTransaction();

//        session.save(movieEntity);
        MovieEntity savedMovie = movieService.saveOrUpdate(movieEntity);
        System.out.println("================== savedMovie=" + savedMovie);
        System.out.println("================== savedMovie.title=" + savedMovie.getTitle());
        System.out.println("================== savedMovie.genre=" + savedMovie.getGenre());
        System.out.println("================== savedMovie.rating=" + savedMovie.getMaturityRating());
        System.out.println("================== savedMovie.id=" + savedMovie.getId());
//        session.getTransaction().commit();

        return "addMovie";
    }

}
