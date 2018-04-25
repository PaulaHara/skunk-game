package springmvc.service;

import springmvc.model.Dice;

import java.util.List;

/**
 * @author paula on 11/04/18.
 */
public interface DiceService {
    List<Dice> getDiceResults();
}
