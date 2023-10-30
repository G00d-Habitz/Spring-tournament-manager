package tournaments.tournamentManager.service;

import tournaments.tournamentManager.entity.Player;
import tournaments.tournamentManager.entity.Round;

import java.util.List;

public interface RoundService {
    public Round findRoundById(Long id);
    public void deleteRound(Long id);
    public void updateRound(Round round);
    public void saveRound(Round round);
    public Round createRound(List<Player> players);
}
