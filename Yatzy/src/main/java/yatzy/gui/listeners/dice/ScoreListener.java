package yatzy.gui.listeners.dice;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import yatzy.gui.ScoringScreenGUI;
import yatzy.logic.dice.Dice;
import yatzy.logic.game.*;
import yatzy.logic.player.Human;
import yatzy.logic.scoring.Score;

/**
 *
 * @author Roni
 */
public class ScoreListener implements ActionListener {

    private JButton scoreButton;
    private JButton rerollButton;
    private JButton die1;
    private JButton die2;
    private JButton die3;
    private JButton die4;
    private JButton die5;
    private Score score;
    private Game game;
    private Human player;
    private JButton doneRolling;
    private ArrayList<Dice> dice;

    public ScoreListener(JButton scoreButton, JButton rerollButton, JButton die1, JButton die2, JButton die3, JButton die4, JButton die5, Score score, Game game, Human player, JButton doneRolling, ArrayList<Dice> dice) {
        this.scoreButton = scoreButton;
        this.rerollButton = rerollButton;
        this.die1 = die1;
        this.die2 = die2;
        this.die3 = die3;
        this.die4 = die4;
        this.die5 = die5;
        this.score = score;
        this.game = game;
        this.player = player;
        this.doneRolling = doneRolling;
        this.dice = dice;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        scoreButton.setEnabled(false);
        die1.setText("" + dice.get(0).getValue());
        die2.setText("" + dice.get(1).getValue());
        die3.setText("" + dice.get(2).getValue());
        die4.setText("" + dice.get(3).getValue());
        die5.setText("" + dice.get(4).getValue());
        die1.setEnabled(false);
        die2.setEnabled(false);
        die3.setEnabled(false);
        die4.setEnabled(false);
        die5.setEnabled(false);
        ScoringScreenGUI gui = new ScoringScreenGUI(game, score, player, dice);
        SwingUtilities.invokeLater(gui);
        rerollButton.setEnabled(true);
        scoreButton.setEnabled(true);
        doneRolling.setEnabled(false);
    }
}
