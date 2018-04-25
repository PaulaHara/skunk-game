package springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import springmvc.model.Dice;
import springmvc.model.Player;
import springmvc.service.DiceService;
import springmvc.service.PlayerService;

@RestController
public class HelloWorldRestController {

    @Autowired
    PlayerService playerService;  //Service which will do all data retrieval/manipulation work

    @Autowired
    DiceService diceService;

    //-------------------Retrieve All Players--------------------------------------------------------
    @RequestMapping(value = "/player/", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> listAllPlayers() {
        List<Player> players = playerService.findAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    //-------------------Retrieve Single Player--------------------------------------------------------
    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getPlayer(@PathVariable("id") long id) {
        System.out.println("Fetching Player with id " + id);
        Player player = playerService.findById(id);
        if (player == null) {
            System.out.println("Player with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    //-------------------Create a Player--------------------------------------------------------
    @RequestMapping(value = "/player/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlayer(@RequestBody Player player, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Player " + player.getName());

        if (playerService.isPlayerExist(player)) {
            System.out.println("A Player with name " + player.getName() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        playerService.savePlayer(player);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/player/{id}").buildAndExpand(player.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Player --------------------------------------------------------
    @RequestMapping(value = "/player/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") long id, @RequestBody Player player) {
        System.out.println("Updating Player " + id + ", score: " + player.getScore());

        Player currentPlayer = playerService.findById(id);

        if (currentPlayer==null) {
            System.out.println("Player with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentPlayer.setName(player.getName());
        currentPlayer.setScore(player.getScore());
        currentPlayer.setStand(player.isStand());

        playerService.updatePlayer(currentPlayer);
        return new ResponseEntity<>(currentPlayer, HttpStatus.OK);
    }

    //------------------- Delete a Player --------------------------------------------------------
    @RequestMapping(value = "/player/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Player> deletePlayer(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Player with id " + id);

        Player player = playerService.findById(id);
        if (player == null) {
            System.out.println("Unable to player. Player with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        playerService.deletePlayerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //------------------- Delete All Players --------------------------------------------------------
    @RequestMapping(value = "/player/", method = RequestMethod.DELETE)
    public ResponseEntity<Player> deleteAllPlayers() {
        System.out.println("Deleting All Players");

        playerService.deleteAllPlayers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //-------------------Rolling Dice--------------------------------------------------------
    @RequestMapping(value = "/dice/", method = RequestMethod.GET)
    public ResponseEntity<List<Dice>> rollDice() {
        List<Dice> dices = diceService.getDiceResults();
        return new ResponseEntity<>(dices, HttpStatus.OK);
    }

}
