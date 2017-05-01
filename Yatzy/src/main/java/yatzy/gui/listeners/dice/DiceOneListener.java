package yatzy.gui.listeners.dice;

import java.awt.event.*;
import java.util.ArrayList;
import yatzy.logic.dice.Dice;
import yatzy.logic.game.*;

/**
 *
 * @author Roni
 */
public class DiceOneListener implements ActionListener {

    private ArrayList<Dice> dice;
    private Game game;
    
    public DiceOneListener(ArrayList<Dice> dice,Game game){
        this.game = game;
        this.dice = dice;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        game.rerollDie(1);
    }
}
