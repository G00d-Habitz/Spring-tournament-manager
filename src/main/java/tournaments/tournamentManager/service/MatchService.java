package tournaments.tournamentManager.service;

import tournaments.tournamentManager.entity.Match;

public interface MatchService {
    public Match findMatchById(Long id);
    public void deleteMatch(Long id);
    public void updateMatch(Match match);
    public void createMatch(Match match);

}
