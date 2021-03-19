package org.sid.cinema.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Seance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Temporal(TemporalType.TIME)
    private Date heuredebut;

    public Seance(Long id, Date heuredebut) {
        this.id = id;
        this.heuredebut = heuredebut;
    }

    public Seance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(Date heuredebut) {
        this.heuredebut = heuredebut;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "id=" + id +
                ", heuredebut=" + heuredebut +
                '}';
    }
}
