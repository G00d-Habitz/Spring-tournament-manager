package tournaments.tournamentManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tournaments.tournamentManager.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
