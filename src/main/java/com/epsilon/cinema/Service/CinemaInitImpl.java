package com.epsilon.cinema.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epsilon.cinema.dao.CategorieRepository;
import com.epsilon.cinema.dao.CinemaRepository;
import com.epsilon.cinema.dao.FilmRepository;
import com.epsilon.cinema.dao.PlaceRepository;
import com.epsilon.cinema.dao.ProjectionRepository;
import com.epsilon.cinema.dao.SalleRepository;
import com.epsilon.cinema.dao.SeanceRepository;
import com.epsilon.cinema.dao.TicketRepository;
import com.epsilon.cinema.dao.VilleRepository;
import com.epsilon.cinema.entities.Categorie;
import com.epsilon.cinema.entities.Cinema;
import com.epsilon.cinema.entities.Film;
import com.epsilon.cinema.entities.Place;
import com.epsilon.cinema.entities.Projection;
import com.epsilon.cinema.entities.Salle;
import com.epsilon.cinema.entities.Seance;
import com.epsilon.cinema.entities.Ticket;
import com.epsilon.cinema.entities.Ville;
@Service
@Transactional
public class CinemaInitImpl implements ICinemaInitService{

	@Autowired
	private VilleRepository villeRepository; 
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private SalleRepository salleRepository;
	
	@Autowired
	private PlaceRepository placeRepository;
	
	@Autowired
	private SeanceRepository seanceRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private ProjectionRepository projectionRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public void initVilles() {
	
		Stream.of("Casblanca","Rabat","Marakeck","Terangua","Silicon VAlley").
		forEach(nameVille->{
			Ville ville=new Ville();
			ville.setName(nameVille);
			villeRepository.save(ville);
		});
		
	}

	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(v->{
		  Stream.of("Vandame","Silicon Valley","Epsilon","Simplon Senegal").
		  forEach(nameCinema->{
			  Cinema cinema=new Cinema();
			  cinema.setName(nameCinema);
			  cinema.setNombreSalles(3+(int)Math.random()*7);
			  cinema.setVille(v);
			  cinemaRepository.save(cinema);
			  
		  });
		});
		
	}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema->{
			for(int i=0;i<cinema.getNombreSalles();i++) {
			   Salle salle=new Salle();
			   salle.setName("salle"+(i+1));
			   salle.setCinema(cinema);
			   salle.setNombePlace(15+(int)(Math.random()*20));
			   salleRepository.save(salle);
			}
		});
		
	}
	
	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle->{
			for(int i=0;i<salle.getNombePlace();i++) {
				Place place=new Place();
				place.setNumero(i+1);
				place.setSalle(salle);
				placeRepository.save(place);
			}
		});
		
	}
	
	@Override
	public void initSeances() {
		DateFormat dateFormat=new SimpleDateFormat("HH:mm");
		Stream.of("12:00","15:00","17:00","19:00","21:00").
		forEach(s->{
			Seance seance=new Seance();
			try {
				seance.setHeureDebut(dateFormat.parse(s));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		
	}

	@Override
	public void initProjections() {
		double[]  prices =new double[] {30,50,60,70,90,100};
		List<Film> films=filmRepository.findAll();
		villeRepository.findAll().forEach(ville->{
			ville.getCinemas().forEach(cinema->{
				cinema.getSalles().forEach(salle->{
					int index=new Random().nextInt(films.size());
					Film film=films.get(index); 
						seanceRepository.findAll().forEach(seance->{
							Projection projection=new Projection();
							projection.setDateProjection(new Date());
							projection.setFilm(film);
							projection.setPrix(prices[new Random().nextInt(prices.length) ]);
							projection.setSalle(salle);
							projection.setSeance(seance);
							projectionRepository.save(projection);
						});
				});
			});
		});
	}

	@Override
 	public void initTickets() {
		projectionRepository.findAll().forEach(p->{
			p.getSalle().getPlaces().forEach(place->{
				Ticket ticket=new Ticket();
				ticket.setPlace(place);
				ticket.setPrix(p.getPrix());
				ticket.setProjection(p);
				ticket.setReserve(false);
				ticketRepository.save(ticket);
				
			});
		});	
	}

	@Override
	public void initCategories() {
		Stream.of("Actions","Fictions","Drame","Histoires").forEach(cat->{
			Categorie categorie=new Categorie();
		    categorie.setName(cat);
		    categorieRepository.save(categorie);
		    
		});
		
	}

	@Override
	public void initFilms() {
		List<Categorie> categories=categorieRepository.findAll();
		Double[] duree=new Double[] {1.0,1.5,2.0,2.5,3.0};
		Stream.of("12 homme en colére","Forset Gump","Green Book","Seigneur des anneaux","La ligne rouge").
		forEach(f->{
			Film film=new Film();
			film.setTitre(f);
			film.setDuree(duree[new Random().nextInt(duree.length)]);
			film.setPhoto(f.replaceAll(" ", ""));
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);    
		});
	}
}
