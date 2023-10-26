package tournaments.tournamentManager.controller;

import org.springframework.stereotype.Controller;
import tournaments.tournamentManager.service.MatchService;

@Controller
public class MatchController {
    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
}
