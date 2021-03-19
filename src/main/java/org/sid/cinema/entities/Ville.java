package org.sid.cinema.entities;

import javax.persistence.*;
import java.util.Collection;
@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private double longitude,latitude,altitude;
    @OneToMany(mappedBy = "ville")
    private Collection<Cinema> cinemas;

    public Ville(Long id, String name, double longitude, double latitude, double altitude, Collection<Cinema> cinemas) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.cinemas = cinemas;
    }

    public Collection<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Collection<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public Ville() {
    }

    public Ville(Long id, String name, double longitude, double latitude, double altitude) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Ville{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                '}';
    }
}
