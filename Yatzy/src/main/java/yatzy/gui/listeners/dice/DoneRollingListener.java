package yatzy.gui.listeners.dice;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import yatzy.gui.ScoringScreenGUI;
import yatzy.logic.dice.Dice;
import yatzy.logic.game.*;
import yatzy.logic.scoring.*;
import yatzy.logic.player.*;

/**
 *
 * @author Roni
 */
public class DoneRollingListener implements ActionListener {

    private JTextArea die1;
    private JTextArea die2;
    private JTextArea die3;
    private JTextArea die4;
    private JTextArea die5;
    private ArrayList<Dice> dice;
    private Game game;
    private Score score;
    private Human player;

    public DoneRollingListener(JTextArea die1, JTextArea die2, JTextArea die3, JTextArea die4, JTextArea die5, ArrayList<Dice> dice, Game game, Score score, Human player) {
        this.die1 = die1;
        this.die2 = die2;
        this.die3 = die3;
        this.die4 = die4;
        this.die5 = die5;
        this.dice = dice;
        this.game = game;
        this.score = score;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (game.checkRerolls() == 0) {
            die1.setText("" + dice.get(0).getValue());
            die2.setText("" + dice.get(1).getValue());
            die3.setText("" + dice.get(2).getValue());
            die4.setText("" + dice.get(3).getValue());
            die5.setText("" + dice.get(4).getValue());
            game.addReroll();
        } else {
            die1.setText("" + dice.get(0).getValue());
            die2.setText("" + dice.get(1).getValue());
            die3.setText("" + dice.get(2).getValue());
            die4.setText("" + dice.get(3).getValue());
            die5.setText("" + dice.get(4).getValue());
            game.resetRerolls();
            ScoringScreenGUI gui = new ScoringScreenGUI(game, score, player, dice);
            SwingUtilities.invokeLater(gui);
        }
    }
}
