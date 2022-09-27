package com.javaunit3.springmvc.repository;

import com.javaunit3.springmvc.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    public MovieEntity findByTitle(String title);

    public List<MovieEntity> findByGenre(String genre);

    public List<MovieEntity> findByMaturityRating(String maturityRating);

}
