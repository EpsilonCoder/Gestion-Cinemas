package com.epsilon.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.epsilon.cinema.entities.Ticket;
@RepositoryRestController
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
