package com.example.nbaback;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    int passe_decisives;
    int points;
    int rebonds;
    double temps;
    
    @ManyToOne
    @JoinColumn(name = "id_joueur")
    Joueur joueur;

    @ManyToOne
    @JoinColumn(name="id_match")
    Match match;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPasse_decisives() {
        return passe_decisives;
    }

    public void setPasse_decisives(int passe_decisives) {
        this.passe_decisives = passe_decisives;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRebonds() {
        return rebonds;
    }

    public void setRebonds(int rebonds) {
        this.rebonds = rebonds;
    }

    public double getTemps() {
        return temps;
    }

    public void setTemps(double temps) {
        this.temps = temps;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
        
}
