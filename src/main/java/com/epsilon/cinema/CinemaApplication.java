package com.epsilon.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.epsilon.cinema.Service.CinemaInitImpl;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}
	
	@Autowired
	private CinemaInitImpl cinemaInitImpl;

	@Override
	public void run(String... args) throws Exception {
		
		//cinemaInitImpl.initVilles();
		//cinemaInitImpl.initCinemas();
		//cinemaInitImpl.initSalles();
		//cinemaInitImpl.initSeances();
		//cinemaInitImpl.initPlaces();
		//cinemaInitImpl.initCategories();
		//cinemaInitImpl.initFilms();
		//cinemaInitImpl.initProjections();
		//cinemaInitImpl.initTickets();
			
	}

}
