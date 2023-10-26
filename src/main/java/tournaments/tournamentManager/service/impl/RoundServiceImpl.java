package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.repository.RoundRepository;
import tournaments.tournamentManager.service.RoundService;

@Service
public class RoundServiceImpl implements RoundService {
    private RoundRepository roundRepository;

    public RoundServiceImpl(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }
}
