package tournaments.tournamentManager.controller;

import org.springframework.stereotype.Controller;
import tournaments.tournamentManager.service.RoundService;

@Controller
public class RoundController {
    private RoundService roundService;

    public RoundController(RoundService roundService) {
        this.roundService = roundService;
    }
}
