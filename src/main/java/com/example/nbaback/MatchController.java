package com.example.nbaback;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MatchController {
    @Autowired
    MatchRep mr;

    @Autowired
    EquipeRep er;

    @PostMapping(path = "/match")
    public @ResponseBody String addMatch(
            @RequestParam int idEquipe1,
            @RequestParam int idEquipe2,
            @RequestParam int points1,
            @RequestParam int points2) {
        Match m = new Match();
        m.setPoints1(points1);
        m.setPoints2(points2);
        Equipe Equipe1 = er.findById(idEquipe1).get();
        Equipe Equipe2 = er.findById(idEquipe2).get();
        m.setEquipe1(Equipe1);
        m.setEquipe2(Equipe2);
        
        mr.save(m);
        return "saved";
    }

    @GetMapping(path = "/matchs")
    public @ResponseBody Iterable<Match> getAllMatchs(){
        return mr.findAll();
    }

}
