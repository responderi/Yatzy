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

    private JLabel die1;
    private JLabel die2;
    private JLabel die3;
    private JLabel die4;
    private JLabel die5;
    public ArrayList<Dice> dice;
    public Game game;
    public Score score;
    public Human player1, player2;
    public JButton rerollButton;

    public DoneRollingListener(JLabel die1, JLabel die2, JLabel die3, JLabel die4, JLabel die5, ArrayList<Dice> dice, Game game, Score score, Human player1, Human player2, JButton rerollButton) {
        this.die1 = die1;
        this.die2 = die2;
        this.die3 = die3;
        this.die4 = die4;
        this.die5 = die5;
        this.dice = dice;
        this.game = game;
        this.score = score;
        this.player1 = player1;
        this.player2 = player2;
        this.rerollButton = rerollButton;
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
            ScoringScreenGUI scoringGui = new ScoringScreenGUI(game, score, player1, player2, dice);
            SwingUtilities.invokeLater(scoringGui);
            rerollButton.setEnabled(true);
        }
    }
}
