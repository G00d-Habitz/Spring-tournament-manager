package tournaments.tournamentManager.service;


import tournaments.tournamentManager.entity.Player;

public interface PlayerService {
    public Player findPlayerById(Long id);
    public void deletePlayer(Long id);
    public void updatePlayer(Player player);
    public void createPlayer(Player player);

}
