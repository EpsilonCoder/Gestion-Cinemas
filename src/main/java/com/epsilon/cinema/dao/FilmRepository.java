package com.epsilon.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.epsilon.cinema.entities.Film;

@RepositoryRestController
@CrossOrigin("*")
public interface FilmRepository extends JpaRepository<Film, Long>{

}
