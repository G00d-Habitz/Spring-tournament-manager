package tournaments.tournamentManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tournaments.tournamentManager.entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
