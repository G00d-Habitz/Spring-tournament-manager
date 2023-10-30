package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.entity.Match;
import tournaments.tournamentManager.entity.Player;
import tournaments.tournamentManager.repository.MatchRepository;
import tournaments.tournamentManager.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match findMatchById(Long id) {
        return matchRepository.findById(id).get();
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    @Override
    public void updateMatch(Match match) {
        matchRepository.save(match);
    }

    @Override
    public void saveMatch(Match match) {
        matchRepository.save(match);
    }

    @Override
    public Match createMatch(Player player1, Player player2) {
        Match match = new Match();
        match.setPlayerOne(player1);
        match.setPlayerTwo(player2);
        match = matchRepository.save(match);
        return match;
    }
}
