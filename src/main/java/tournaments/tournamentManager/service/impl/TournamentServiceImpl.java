package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.entity.Player;
import tournaments.tournamentManager.entity.Tournament;
import tournaments.tournamentManager.repository.TournamentRepository;
import tournaments.tournamentManager.service.TournamentService;

import java.util.Comparator;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {
    private TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Tournament findTournamentById(Long id) {
        return tournamentRepository.findById(id).get();
    }

    @Override
    public List<Tournament> findAllTournaments() {
        return tournamentRepository.findAll();
    }

    @Override
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    @Override
    public void updateTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    @Override
    public void createTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    @Override
    public List<Player> sortByRating(Long id) {
        Tournament tournament = tournamentRepository.findById(id).get();
        List<Player> players = tournament.getPlayers();
        players.sort(Comparator.comparing(Player::getRating).reversed());
        return players;
    }

    @Override
    public List<Player> sortBeforeRound(Long id) {
        Tournament tournament = tournamentRepository.findById(id).get();
        List<Player> players = tournament.getPlayers();
        players.sort(Comparator.comparing(Player::getScore).reversed()
                .thenComparing(Player::getBuchholzCut1).reversed()
                .thenComparing(Player::getBuchholz).reversed());
        return players;
    }
}
