package org.sid.cinema.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Cinema implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private double longitude,latitude,altitude;
   private int nombreSalles;
   @OneToMany(mappedBy = "cinema")
   private Collection <Salle> salles;
   @ManyToOne
   private  Ville ville;

    public Cinema(Long id, String name, double longitude, double latitude, double altitude, int nombreSalles, Collection<Salle> salles, Ville ville) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.nombreSalles = nombreSalles;
        this.salles = salles;
        this.ville = ville;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Collection<Salle> getSalles() {
        return salles;
    }

    public void setSalles(Collection<Salle> salles) {
        this.salles = salles;
    }


    public Cinema() {
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                ", nombreSalles=" + nombreSalles +
                '}';
    }

    public int getNombreSalles() {
        return nombreSalles;
    }

    public void setNombreSalles(int nombreSalles) {
        this.nombreSalles = nombreSalles;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cinema(Long id, String name, double longitude, double latitude, double altitude, int nombreSalles) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.nombreSalles = nombreSalles;
    }



}
