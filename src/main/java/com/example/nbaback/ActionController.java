package com.example.nbaback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ActionController {
    @Autowired
    ActionRep ar;

    @Autowired
    MatchRep mr;

    @Autowired
    JoueurRep jr;

    public @ResponseBody String addAction(
        @RequestParam int idMatch,
        @RequestParam int idJoueur,
        @RequestParam int passe_decisives,
        @RequestParam int points,
        @RequestParam int rebond,
        @RequestParam double temps
    ){
        Action a = new Action();
        //joueur et match
        Match match = mr.findById(idMatch).get();
        Joueur joueur = jr.findById(idJoueur).get();
        a.setMatch(match);
        a.setJoueur(joueur);
        //others
        a.setPoints(points);
        a.setRebonds(rebond);
        a.setPasse_decisives(passe_decisives);
        a.setTemps(temps);

        //insertion
        ar.save(a);
        return "saved";        
    }

    public @ResponseBody Iterable<Action> getAllActions(){
        return ar.findAll();
    }
}
