package org.sid.cinema.service;

import org.sid.cinema.dao.*;
import org.sid.cinema.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemainitServiceImpl implements ICinemainitService {
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
    private FilmRepository filmRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public void initVilles() {
        Stream.of("casa","fes","rabat","tanger").forEach(v->{
            Ville ville=new Ville();
            ville.setName(v);
            villeRepository.save(ville);
        });
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(ville -> {
        Stream.of("megarama","imax","fonon","chahrazad","daouliz").forEach(nameCinema->{
            Cinema cinema=new Cinema();
            cinema.setName(nameCinema);
            cinema.setVille(ville);
            cinema.setNombreSalles(10);
            cinemaRepository.save(cinema);
        });
        });
    }

    @Override
    public void initSalles() {
     cinemaRepository.findAll().forEach(cinema -> {
     for (int i=0;i<cinema.getNombreSalles();i++) {
         Salle salle=new Salle();
         salle.setName("Salle "+(i+1));
         salle.setCinema(cinema);
         salle.setNombrePlace(50);
         salleRepository.save(salle);
     }
     });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle -> {
            for (int i=0;i<salle.getNombrePlace();i++)
            {
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
     Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s -> {
         Seance seance=new Seance();
         try {
             seance.setHeuredebut(dateFormat.parse(s));
             seanceRepository.save(seance);
         } catch (ParseException e) {
             e.printStackTrace();
         }
     });


    }



    @Override
    public void initCategories() {
     Stream.of("Histoire","Action","Fiction","Drama").forEach(cat->{
         Categorie categorie=new Categorie();
         categorie.setName(cat);
         categorieRepository.save(categorie);
     });
    }

    @Override
    public void initfilms() {
        List<Categorie> categories=categorieRepository.findAll();
     Stream.of("game of tronnes","seingneur des anneaux","spider man","iron man","cat women").forEach(f->{
         Film film=new Film();
         film.setTitre(f);
         film.setPhoto(f.replaceAll(" ","")+".jpg");
         film.setCategorie(categories.get(new Random().nextInt(categories.size())));
         filmRepository.save(film);
     });
    }

    @Override
    public void initProjections() {
        List<Film> films=filmRepository.findAll();
     villeRepository.findAll().forEach(ville -> {
         ville.getCinemas().forEach(cinema ->{
             cinema.getSalles().forEach(salle -> {
                 int index=new Random().nextInt(films.size());
                 Film film= films.get(index);
                     seanceRepository.findAll().forEach(seance -> {
                         Projection projection=new Projection();
                         projection.setDateProjection(new Date());
                         projection.setFilm(film);
                         projection.setPrix(50);
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
      projectionRepository.findAll().forEach(projection -> {
          projection.getSalle().getPlaces().forEach(place -> {
              Ticket ticket=new Ticket();
              ticket.setPlace(place);
              ticket.setPrix(projection.getPrix());
              ticket.setReserve(false);
              ticket.setProjection(projection);
              ticketRepository.save(ticket);
          });
      });
    }
}
