package tournaments.tournamentManager.controller;

import org.springframework.stereotype.Controller;
import tournaments.tournamentManager.service.TournamentService;

@Controller
public class TournamentController {
    private TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }
}
