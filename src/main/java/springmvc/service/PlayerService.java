package springmvc.service;

import springmvc.model.Player;

import java.util.List;

public interface PlayerService {

    Player findById(long id);

    Player findByName(String name);

    void savePlayer(Player player);

    void updatePlayer(Player player);

    void deletePlayerById(long id);

    List<Player> findAllPlayers();

    void deleteAllPlayers();

    boolean isPlayerExist(Player player);
}
