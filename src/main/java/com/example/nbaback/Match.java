package com.example.nbaback;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @ManyToOne
    @JoinColumn(name="equipe_1")
    Equipe equipe1;

    @ManyToOne
    @JoinColumn(name="equipe_2")
    Equipe equipe2;

    Integer points1;
    Integer points2;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Equipe getEquipe1() {
        return equipe1;
    }
    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }
    public Equipe getEquipe2() {
        return equipe2;
    }
    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }
    public Integer getPoints1() {
        return points1;
    }
    public void setPoints1(Integer points1) {
        this.points1 = points1;
    }
    public Integer getPoints2() {
        return points2;
    }
    public void setPoints2(Integer points2) {
        this.points2 = points2;
    }
}
