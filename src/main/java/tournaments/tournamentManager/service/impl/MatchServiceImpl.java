package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.repository.MatchRepository;
import tournaments.tournamentManager.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
}
