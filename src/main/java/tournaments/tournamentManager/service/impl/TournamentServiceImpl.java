package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.repository.TournamentRepository;
import tournaments.tournamentManager.service.TournamentService;

@Service
public class TournamentServiceImpl implements TournamentService {
    private TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }
}
