package yatzy.gui.listeners.dice;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import yatzy.logic.dice.Dice;
import yatzy.logic.game.*;

/**
 *
 * @author Roni
 */
public class DiceThreeListener implements ActionListener {

    private ArrayList<Dice> dice;
    private Game game;
    private JButton button, doneButton, scoreButton;
    
    public DiceThreeListener(ArrayList<Dice> dice,Game game,JButton button,JButton doneButton,JButton scoreButton){
        this.game = game;
        this.dice = dice;
        this.button = button;
        this.doneButton = doneButton;
        this.scoreButton = scoreButton;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        game.rerollDie(3);
        button.setEnabled(false);
        scoreButton.setEnabled(false);
        doneButton.setEnabled(true);
    }
}