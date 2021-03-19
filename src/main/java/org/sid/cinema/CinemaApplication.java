package org.sid.cinema;

import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Salle;
import org.sid.cinema.entities.Ticket;
import org.sid.cinema.service.ICinemainitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

    @Autowired
    private ICinemainitService iCinemainitService;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        restConfiguration.exposeIdsFor(Film.class, Salle.class, Ticket.class);
        iCinemainitService.initVilles();
        iCinemainitService.initCinemas();
        iCinemainitService.initSalles();
        iCinemainitService.initPlaces();
        iCinemainitService.initSeances();
        iCinemainitService.initCategories();
        iCinemainitService.initfilms();
        iCinemainitService.initProjections();
        iCinemainitService.initTickets();

    }
}
