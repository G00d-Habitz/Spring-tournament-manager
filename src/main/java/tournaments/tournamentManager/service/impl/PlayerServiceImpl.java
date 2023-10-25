package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.repository.PlayerRepository;
import tournaments.tournamentManager.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
}
