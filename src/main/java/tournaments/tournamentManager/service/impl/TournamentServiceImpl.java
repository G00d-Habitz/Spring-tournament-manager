package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.entity.Tournament;
import tournaments.tournamentManager.repository.TournamentRepository;
import tournaments.tournamentManager.service.TournamentService;

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
}
