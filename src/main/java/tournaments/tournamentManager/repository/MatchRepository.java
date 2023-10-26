package tournaments.tournamentManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tournaments.tournamentManager.entity.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
