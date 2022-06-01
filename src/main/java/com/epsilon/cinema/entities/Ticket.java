package com.epsilon.cinema.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
  @Id 	@GeneratedValue
	
  private Long id;
  private String nomClient;
  
  private Double prix;
  @Column(unique=false,nullable = true)
  private Integer codePayement;
  private boolean reserve;
  @ManyToOne
  private Place place;
  @ManyToOne
  private Projection projection;
}