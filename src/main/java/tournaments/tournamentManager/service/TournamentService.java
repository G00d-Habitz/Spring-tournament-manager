package tournaments.tournamentManager.service;

import tournaments.tournamentManager.entity.Player;
import tournaments.tournamentManager.entity.Tournament;

public interface TournamentService {
    public Tournament findTournamentById(Long id);
    public void deleteTournament(Long id);
    public void updateTournament(Tournament tournament);
    public void createTournament(Tournament tournament);
}
