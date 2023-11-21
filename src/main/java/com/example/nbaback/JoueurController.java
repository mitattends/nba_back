package com.example.nbaback;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoueurController {
    @Autowired
    JoueurRep jr;

    @Autowired
    EquipeRep er;

    @PostMapping(path = "/joueur")
    public @ResponseBody String addJoueur(
        @RequestParam String nom,
        @RequestParam String prenom,
        @RequestParam int idEquipe
    )
    {
        Joueur j = new Joueur();
        j.setNom(nom);
        j.setPrenom(prenom);

        Optional<Equipe> e = er.findById(idEquipe);
        j.setEquipe(e.get());

        jr.save(j);

        return "saved";

    }

    @GetMapping(path = "/joueurs")
    public @ResponseBody Iterable<Joueur> getAllJoueurs(){
        return jr.findAll();
    }
}

