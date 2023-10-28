package tournaments.tournamentManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tournaments.tournamentManager.entity.Player;
import tournaments.tournamentManager.service.PlayerService;

import java.util.List;

@Controller
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/players")
    public String showAllPlayers(Model model) {
        List<Player> players = playerService.findAllPlayers();
        model.addAttribute("players", players);
        return "playerList";
    }

    @GetMapping("/players/{id}")
    public String showPlayerInfo(Model model, @PathVariable Long id) {
        Player player = playerService.findPlayerById(id);
        model.addAttribute("player", player);
        return "playerInfo";
    }

    @GetMapping("/players/add")
    public String addPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "addPlayer";
    }

}
