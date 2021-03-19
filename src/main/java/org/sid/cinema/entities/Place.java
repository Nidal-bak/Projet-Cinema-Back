package org.sid.cinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Place {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private double longitude,latitude,altitude;
    @ManyToOne
    private Salle salle;
    @OneToMany(mappedBy = "place")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Place(Long id, int numero, double longitude, double latitude, double altitude, Salle salle, Collection<Ticket> tickets) {
        this.id = id;
        this.numero = numero;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.salle = salle;
        this.tickets = tickets;
    }

    public Place() {
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", numero=" + numero +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                ", salle=" + salle +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Place(Long id, int numero, double longitude, double latitude, double altitude, Salle salle) {
        this.id = id;
        this.numero = numero;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.salle = salle;
    }
}
