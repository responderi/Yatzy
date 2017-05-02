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
    public JButton die1Button, die2Button, die3Button, die4Button, die5Button, doneRolling, scoreButton;

    public DoneRollingListener(JLabel die1, JLabel die2, JLabel die3, JLabel die4, JLabel die5, ArrayList<Dice> dice, Game game, Score score, Human player1, Human player2, JButton rerollButton, JButton die1Button, JButton die2Button, JButton die3Button, JButton die4Button, JButton die5Button, JButton doneRolling, JButton scoreButton) {
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
        this.die1Button = die1Button;
        this.die2Button = die2Button;
        this.die3Button = die3Button;
        this.die4Button = die4Button;
        this.die5Button = die5Button;
        this.doneRolling = doneRolling;
        this.scoreButton = scoreButton;
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
            die1Button.setEnabled(false);
            die2Button.setEnabled(false);
            die3Button.setEnabled(false);
            die4Button.setEnabled(false);
            die5Button.setEnabled(false);
            doneRolling.setEnabled(false);
            scoreButton.setEnabled(false);
            ScoringScreenGUI scoringGui = new ScoringScreenGUI(game, score, player1, player2, dice);
            SwingUtilities.invokeLater(scoringGui);
            rerollButton.setEnabled(true);
        }
    }
}
