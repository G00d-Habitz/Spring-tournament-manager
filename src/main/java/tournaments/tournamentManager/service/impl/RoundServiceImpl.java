package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.entity.Match;
import tournaments.tournamentManager.entity.Player;
import tournaments.tournamentManager.entity.Round;
import tournaments.tournamentManager.repository.RoundRepository;
import tournaments.tournamentManager.service.MatchService;
import tournaments.tournamentManager.service.RoundService;

import java.util.ArrayList;
import java.util.Comparator;
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
        int size = players.size();
        if (players.get(0).getScore() == 0) {

            players.sort(Comparator.comparing(Player::getRating).reversed());

            for (int i = 0, i1 = size/2; i < size/2;i++, i1++) {
                Match match = matchService.createMatch(players.get(i), players.get(i1));
                round.getRoundMatches().add(match);
            }
        } else {

            players.sort(Comparator.comparing(Player::getScore).reversed());

            List<Player> copyList = new ArrayList<>(players);
            while (copyList.size() > 1) {
                Player player1 = copyList.get(0);
                for (int i = 1; i < copyList.size(); i++) {
                    if (!player1.getOpponents().contains(copyList.get(i))) {
                        Player player2 = copyList.get(i);
                        Match match = matchService.createMatch(player1, player2);
                        round.getRoundMatches().add(match);
                        copyList.remove(0);
                        copyList.remove(i);
                        break;
                    }
                }

            }
        }

        if (size%2 == 1) {
            Match match = matchService.createMatch(players.get(size-1), null);
            round.getRoundMatches().add(match);
        }

        return round;
    }
}
