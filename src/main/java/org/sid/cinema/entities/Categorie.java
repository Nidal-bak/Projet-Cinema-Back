package org.sid.cinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
@Entity
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "categorie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Film> films;

    public Categorie(Long id, String name, Collection<Film> films) {
        this.id = id;
        this.name = name;
        this.films = films;
    }

    public Collection<Film> getFilms() {
        return films;
    }

    public void setFilms(Collection<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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

    public Categorie(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Categorie() {
    }


}
