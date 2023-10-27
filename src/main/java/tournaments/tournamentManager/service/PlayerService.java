package tournaments.tournamentManager.service;


import tournaments.tournamentManager.entity.Player;

import java.util.List;

public interface PlayerService {
    public Player findPlayerById(Long id);
    public List<Player> findAllPlayers();
    public void deletePlayer(Long id);
    public void updatePlayer(Player player);
    public void createPlayer(Player player);

}
