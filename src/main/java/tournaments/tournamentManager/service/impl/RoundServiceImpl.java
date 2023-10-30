package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.entity.Match;
import tournaments.tournamentManager.entity.Player;
import tournaments.tournamentManager.entity.Round;
import tournaments.tournamentManager.repository.RoundRepository;
import tournaments.tournamentManager.service.MatchService;
import tournaments.tournamentManager.service.RoundService;

import java.util.List;

@Service
public class RoundServiceImpl implements RoundService {
    private RoundRepository roundRepository;
    private MatchService matchService;

    public RoundServiceImpl(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    @Override
    public Round findRoundById(Long id) {
        return roundRepository.findById(id).get();
    }

    @Override
    public void deleteRound(Long id) {
        roundRepository.deleteById(id);
    }

    @Override
    public void updateRound(Round round) {
        roundRepository.save(round);
    }

    @Override
    public void saveRound(Round round) {
        roundRepository.save(round);
    }

    @Override
    public Round createRound(List<Player> players) {
        Round round = new Round();
        if (players.get(0).getScore() == 0) {
            int size = players.size();
            for (int i = 0, i1 = size/2; i < size/2;i++, i1++) {
                Match match = matchService.createMatch(players.get(i), players.get(i1));
                round.getRoundMatches().add(match);
            }
            if (size%2 == 1) {
                Match match = matchService.createMatch(players.get(size-1), null);
                round.getRoundMatches().add(match);
            }
        }

        // code for creating the round if it's not a first round should go here.


        return round;
    }
}
