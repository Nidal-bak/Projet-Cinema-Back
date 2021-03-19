package org.sid.cinema.web;

import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Salle;
import org.sid.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @GetMapping("/listFilms")
    public List<Film> films(){
        return filmRepository.findAll();
    }
    @GetMapping(path="imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public  byte[] image(@PathVariable (name="id") Long id) throws Exception{
        Film film=filmRepository.findById(id).get();
        String photoName= film.getPhoto();
        File file=new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);

    }
    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm ){
        List <Ticket> ticketList=new ArrayList<>();
        ticketForm.getTickets().forEach(id->{
            Ticket ticket=ticketRepository.findById(id).get();
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setReserve(true);
            ticket.setCodePayement(ticketForm.getCodePayement());
            ticketRepository.save(ticket);
            ticketList.add(ticket);
        });
        return ticketList;
    }
}

class TicketForm {
    private  String nomClient;
    private int codePayement;
    private List<Long> tickets=new ArrayList<>();

    public int getCodePayement() {
        return codePayement;
    }

    public void setCodePayement(int codePayement) {
        this.codePayement = codePayement;
    }

    public TicketForm(String nomClient, int codePayement, List<Long> tickets) {
        this.nomClient = nomClient;
        this.codePayement = codePayement;
        this.tickets = tickets;
    }



    public TicketForm() {
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }
}
