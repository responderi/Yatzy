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
    private JButton die1Button;
    private JButton die2Button;
    private JButton die3Button;
    private JButton die4Button;
    private JButton die5Button;
    public Score score;
    public Game game;
    public Human player1, player2;
    private JButton doneRolling;
    public ArrayList<Dice> dice;
    private JLabel die1, die2, die3, die4, die5;

    public ScoreListener(JButton scoreButton, JButton rerollButton, JButton die1Button, JButton die2Button, JButton die3Button, JButton die4Button, JButton die5Button, Score score, Game game, Human player1, Human player2, JButton doneRolling, ArrayList<Dice> dice, JLabel die1, JLabel die2, JLabel die3, JLabel die4, JLabel die5) {
        this.scoreButton = scoreButton;
        this.rerollButton = rerollButton;
        this.die1Button = die1Button;
        this.die2Button = die2Button;
        this.die3Button = die3Button;
        this.die4Button = die4Button;
        this.die5Button = die5Button;
        this.score = score;
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        this.doneRolling = doneRolling;
        this.dice = dice;
        this.die1 = die1;
        this.die2 = die2;
        this.die3 = die3;
        this.die4 = die4;
        this.die5 = die5;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        scoreButton.setEnabled(false);
        die1.setText("" + dice.get(0).getValue());
        die2.setText("" + dice.get(1).getValue());
        die3.setText("" + dice.get(2).getValue());
        die4.setText("" + dice.get(3).getValue());
        die5.setText("" + dice.get(4).getValue());
        game.resetRerolls();
        die1Button.setEnabled(false);
        die2Button.setEnabled(false);
        die3Button.setEnabled(false);
        die4Button.setEnabled(false);
        die5Button.setEnabled(false);
        doneRolling.setEnabled(false);
        ScoringScreenGUI gui = new ScoringScreenGUI(game, score, player1, player2, dice, rerollButton);
        SwingUtilities.invokeLater(gui);
    }
}
