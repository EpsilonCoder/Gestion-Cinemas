package com.epsilon.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.epsilon.cinema.entities.Categorie;
@RepositoryRestController
@CrossOrigin("*")
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
