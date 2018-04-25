package springmvc.service;

import org.springframework.stereotype.Service;
import springmvc.model.Dice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paula on 11/04/18.
 */
@Service("diceService")
public class DiceServiceImpl implements DiceService {

    private static Dice dice1 = new Dice(1, new ArrayList<>());
    private static Dice dice2 = new Dice(2, new ArrayList<>());
    private static List<Dice> dices = new ArrayList<>();

    @Override
    public List<Dice> getDiceResults(){
        if(dices.isEmpty()) {
            dices.add(dice1);
            dices.add(dice2);
        }
        dices.get(0).getResults().add(roll());
        dices.get(1).getResults().add(roll());

        return dices;
    }

    private int roll(){
        return (int) ((Math.random() * 6) + 1);
    }
}
