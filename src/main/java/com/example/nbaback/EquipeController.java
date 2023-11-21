package com.example.nbaback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EquipeController {
    @Autowired
    EquipeRep er;

    @PostMapping(path="/equipe")
    public @ResponseBody String addEquip(
        @RequestParam String nom
    )
    {
        Equipe e = new Equipe();
        e.setNom(nom);
        er.save(e);

        return "saved";
    }

    @GetMapping(path="/equipes")
    public @ResponseBody Iterable<Equipe> getEquipes(){
        return er.findAll();
    }
}
