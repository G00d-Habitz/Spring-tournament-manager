package tournaments.tournamentManager.controller;

import org.springframework.stereotype.Controller;
import tournaments.tournamentManager.service.PlayerService;

@Controller
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
}
