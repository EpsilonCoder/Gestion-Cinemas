package com.epsilon.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.epsilon.cinema.entities.Film;

@RepositoryRestController
public interface FilmRepository extends JpaRepository<Film, Long>{

}
