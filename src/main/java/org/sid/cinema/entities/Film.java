package org.sid.cinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String titre;
    private String description;
    private String realisateur;
    private Date dateSortie;
    private  double duree;
    private String photo;
    @OneToMany(mappedBy = "film")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Projection> projections;
    @ManyToOne
    private Categorie categorie;

    public Film(Long id, String titre, String description, String realisateur, Date dateSortie, double duree, String photo, Collection<Projection> projections, Categorie categorie) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.realisateur = realisateur;
        this.dateSortie = dateSortie;
        this.duree = duree;
        this.photo = photo;
        this.projections = projections;
        this.categorie = categorie;
    }

    public Collection<Projection> getProjections() {
        return projections;
    }

    public void setProjections(Collection<Projection> projections) {
        this.projections = projections;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", dateSortie=" + dateSortie +
                ", duree=" + duree +
                ", photo='" + photo + '\'' +
                ", categorie=" + categorie +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film(Long id, String titre, String description, String realisateur, Date dateSortie, double duree, String photo, Categorie categorie) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.realisateur = realisateur;
        this.dateSortie = dateSortie;
        this.duree = duree;
        this.photo = photo;
        this.categorie = categorie;
    }

    public Film() {
    }


}
