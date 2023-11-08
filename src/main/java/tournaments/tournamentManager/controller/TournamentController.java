package tournaments.tournamentManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tournaments.tournamentManager.entity.Player;
import tournaments.tournamentManager.entity.Round;
import tournaments.tournamentManager.entity.Tournament;
import tournaments.tournamentManager.service.PlayerService;
import tournaments.tournamentManager.service.RoundService;
import tournaments.tournamentManager.service.TournamentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TournamentController {
    private TournamentService tournamentService;
    private RoundService roundService;
    private PlayerService playerService;

    public TournamentController(TournamentService tournamentService, RoundService roundService, PlayerService playerService) {
        this.tournamentService = tournamentService;
        this.roundService = roundService;
        this.playerService = playerService;
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

    @GetMapping("/tournaments/add-players")
    public String addToPlayerList(Model model, @ModelAttribute Tournament tournament) {
        List<Player> players = playerService.findAllPlayers();
        Player player = new Player();
        model.addAttribute("players", players);
        model.addAttribute("player", player);
        model.addAttribute("tournament", tournament);
        return "addToPlayerList";

    }

    @PostMapping("/tournaments/add")
    public String saveTournament(@ModelAttribute Tournament tournament) {
        tournamentService.createTournament(tournament);
        return "redirect:/tournaments";
    }



}
