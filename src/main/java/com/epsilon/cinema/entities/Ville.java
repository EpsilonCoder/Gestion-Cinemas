package com.epsilon.cinema.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ville {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double longitude,latitude,altitude;	
	@OneToMany(mappedBy = "ville")
	private Collection<Cinema> cinemas;
	

}