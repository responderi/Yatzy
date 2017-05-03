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
public class DiceFiveListener implements ActionListener {

    private ArrayList<Dice> dice;
    private Game game;
    private JButton button, doneButton;
    
    public DiceFiveListener(ArrayList<Dice> dice,Game game,JButton button,JButton doneButton){
        this.game = game;
        this.dice = dice;
        this.button = button;
        this.doneButton = doneButton;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        game.rerollDie(5);
        button.setEnabled(false);
        doneButton.setEnabled(true);
    }
}