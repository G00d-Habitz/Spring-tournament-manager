package tournaments.tournamentManager.service.impl;

import org.springframework.stereotype.Service;
import tournaments.tournamentManager.entity.Round;
import tournaments.tournamentManager.repository.RoundRepository;
import tournaments.tournamentManager.service.RoundService;

@Service
public class RoundServiceImpl implements RoundService {
    private RoundRepository roundRepository;

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
    public void createRound(Round round) {
        roundRepository.save(round);
    }
}
