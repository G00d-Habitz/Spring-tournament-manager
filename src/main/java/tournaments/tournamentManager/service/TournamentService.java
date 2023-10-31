package tournaments.tournamentManager.service;

import tournaments.tournamentManager.entity.Player;
import tournaments.tournamentManager.entity.Tournament;

import java.util.List;

public interface TournamentService {
    public Tournament findTournamentById(Long id);
    public List<Tournament> findAllTournaments();
    public void deleteTournament(Long id);
    public void updateTournament(Tournament tournament);
    public void createTournament(Tournament tournament);

}
