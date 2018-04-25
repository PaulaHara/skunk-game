package springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import springmvc.model.Player;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Player> players = new ArrayList<>();

    @Override
    public Player findById(long id) {
        for(Player player : players){
            if(player.getId() == id){
                return player;
            }
        }
        return null;
    }

    @Override
    public Player findByName(String name) {
        for(Player player : players){
            if(player.getName().equalsIgnoreCase(name)){
                return player;
            }
        }
        return null;
    }

    @Override
    public void savePlayer(Player player) {
        player.setId(counter.incrementAndGet());
        players.add(player);
    }

    @Override
    public void updatePlayer(Player player) {
        int index = players.indexOf(player);
        players.set(index, player);
    }

    @Override
    public void deletePlayerById(long id) {
        for(Iterator<Player> iterator = players.iterator(); iterator.hasNext(); ) {
            Player player = iterator.next();
            if (player.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<Player> findAllPlayers() {
        return players;
    }

    @Override
    public void deleteAllPlayers(){
        players.clear();
    }

    @Override
    public boolean isPlayerExist(Player player) {
        return findByName(player.getName())!=null;
    }
}
