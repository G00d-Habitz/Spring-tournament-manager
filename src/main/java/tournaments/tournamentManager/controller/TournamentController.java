package tournaments.tournamentManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tournaments.tournamentManager.entity.Tournament;
import tournaments.tournamentManager.service.TournamentService;

import java.util.List;

@Controller
public class TournamentController {
    private TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping("/tournaments")
    public String showAllTournaments(Model model) {
        List<Tournament> tournamentList = tournamentService.findAllTournaments();
        model.addAttribute("tournamentList", tournamentList);
        return "tournamentList";
    }

    @GetMapping("/tournaments/{id}")
    public String showTournament(Model model, @PathVariable Long id) {
        Tournament tournament = tournamentService.findTournamentById(id);
        model.addAttribute("tournament", tournament);
        return "tournamentInfo";
    }

    @GetMapping("/tournaments/add")
    public String addTournament(Model model) {
        Tournament tournament = new Tournament();
        model.addAttribute("tournament", tournament);
        return "addTournament";
    }



}
