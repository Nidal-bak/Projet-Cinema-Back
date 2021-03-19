package org.sid.cinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
public class Projection {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateProjection;
    private double prix;
    @ManyToOne
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Salle salle;
    @ManyToOne
    private Film film;
    @OneToMany(mappedBy = "projection" )
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;
    @ManyToOne
    private Seance seance;

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Projection(Long id, Date dateProjection, double prix, Salle salle, Film film, Collection<Ticket> tickets, Seance seance) {
        this.id = id;
        this.dateProjection = dateProjection;
        this.prix = prix;
        this.salle = salle;
        this.film = film;
        this.tickets = tickets;
        this.seance = seance;
    }

    public Projection() {
    }

    public Projection(Long id, Date dateProjection, double prix, Salle salle, Film film, Seance seance) {
        this.id = id;
        this.dateProjection = dateProjection;
        this.prix = prix;
        this.salle = salle;
        this.film = film;
        this.seance = seance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateProjection() {
        return dateProjection;
    }

    public void setDateProjection(Date dateProjection) {
        this.dateProjection = dateProjection;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    @Override
    public String toString() {
        return "Projection{" +
                "id=" + id +
                ", dateProjection=" + dateProjection +
                ", prix=" + prix +
                ", salle=" + salle +
                ", film=" + film +
                ", seance=" + seance +
                '}';
    }
}
