package tournaments.tournamentManager.service;

import tournaments.tournamentManager.entity.Round;

public interface RoundService {
    public Round findRoundById(Long id);
    public void deleteRound(Long id);
    public void updateRound(Round round);
    public void createRound(Round round);
}
