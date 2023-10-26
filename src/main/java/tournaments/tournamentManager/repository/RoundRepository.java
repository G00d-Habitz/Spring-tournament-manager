package tournaments.tournamentManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tournaments.tournamentManager.entity.Round;

public interface RoundRepository extends JpaRepository<Round, Long> {
}
