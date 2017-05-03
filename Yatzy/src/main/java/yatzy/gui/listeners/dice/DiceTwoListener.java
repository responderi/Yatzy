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
public class DiceTwoListener implements ActionListener {

    private ArrayList<Dice> dice;
    private Game game;
    private JButton button, doneButton;
    
    public DiceTwoListener(ArrayList<Dice> dice,Game game,JButton button,JButton doneButton){
        this.game = game;
        this.dice = dice;
        this.button = button;
        this.doneButton = doneButton;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        game.rerollDie(2);
        button.setEnabled(false);
        doneButton.setEnabled(true);
    }
}