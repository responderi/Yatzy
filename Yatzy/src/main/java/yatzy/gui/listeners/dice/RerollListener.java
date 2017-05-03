package yatzy.gui.listeners.dice;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import yatzy.gui.GameScreenGUI;
import yatzy.logic.dice.Dice;
import yatzy.logic.game.*;
import yatzy.logic.player.Human;

/**
 *
 * @author Roni
 */
public class RerollListener implements ActionListener {

    private JButton rerollButton, die1Button, die2Button, die3Button, die4Button, die5Button, doneRolling, scoreButton;
    private JLabel die1, die2, die3, die4, die5;
    public GameScreenGUI gui;
    public Game game;
    private ArrayList<Dice> dice;
    public JLabel player1Pair, player2Pair, player1TwoPairs, player2TwoPairs, player1Threes, player2Threes, player1Fours, player2Fours, player1FullHouse, player2FullHouse, player1Sum, player2Sum, player1Yatzy, player2Yatzy, player1Total, player2Total, player1Ones, player2Ones, player1Twos, player2Twos, player1ThreesUp, player2ThreesUp, player1FoursUp, player2FoursUp, player1Fives, player2Fives, player1Sixes, player2Sixes, player1Bonus, player2Bonus, player1Upper, player2Upper, inTurn;
    public Human player1, player2;

    public RerollListener(JButton button, JButton die1Button, JButton die2Button, JButton die3Button, JButton die4Button, JButton die5Button, JButton doneRolling, GameScreenGUI gui, Game game, JLabel die1, JLabel die2, JLabel die3, JLabel die4, JLabel die5, ArrayList<Dice> dice, JLabel player1Pair, JLabel player2Pair, JLabel player1TwoPairs, JLabel player2TwoPairs, JLabel player1Threes, JLabel player2Threes, JLabel player1Fours, JLabel player2Fours, JLabel player1FullHouse, JLabel player2FullHouse, JLabel player1Sum, JLabel player2Sum, JLabel player1Yatzy, JLabel player2Yatzy, JLabel player1Total, JLabel player2Total, Human player1, Human player2, JButton scoreButton, JLabel player1Ones, JLabel player2Ones, JLabel player1Twos, JLabel player2Twos, JLabel player1ThreesUp, JLabel player2ThreesUp, JLabel player1FoursUp, JLabel player2FoursUp, JLabel player1Fives, JLabel player2Fives, JLabel player1Sixes, JLabel player2Sixes, JLabel player1Bonus, JLabel player2Bonus, JLabel player1Upper, JLabel player2Upper, JLabel inTurn) {
        this.rerollButton = button;
        this.die1 = die1;
        this.die2 = die2;
        this.die3 = die3;
        this.die4 = die4;
        this.die5 = die5;
        this.die1Button = die1Button;
        this.die2Button = die2Button;
        this.die3Button = die3Button;
        this.die4Button = die4Button;
        this.die5Button = die5Button;
        this.doneRolling = doneRolling;
        this.gui = gui;
        this.game = game;
        this.dice = dice;
        this.player1Pair = player1Pair;
        this.player2Pair = player2Pair;
        this.player1TwoPairs = player1TwoPairs;
        this.player2TwoPairs = player2TwoPairs;
        this.player1Threes = player1Threes;
        this.player2Threes = player2Threes;
        this.player1Fours = player1Fours;
        this.player2Fours = player2Fours;
        this.player1FullHouse = player1FullHouse;
        this.player2FullHouse = player2FullHouse;
        this.player1Sum = player1Sum;
        this.player2Sum = player2Sum;
        this.player1Yatzy = player1Yatzy;
        this.player2Yatzy = player2Yatzy;
        this.player1Total = player1Total;
        this.player2Total = player2Total;
        this.player1 = player1;
        this.player2 = player2;
        this.scoreButton = scoreButton;
        this.player1Ones = player1Ones;
        this.player2Ones = player2Ones;
        this.player1Twos = player1Twos;
        this.player2Twos = player2Twos;
        this.player1ThreesUp = player1ThreesUp;
        this.player2ThreesUp = player2ThreesUp;
        this.player1FoursUp = player1FoursUp;
        this.player2FoursUp = player2FoursUp;
        this.player1Fives = player1Fives;
        this.player2Fives = player2Fives;
        this.player1Sixes = player1Sixes;
        this.player2Sixes = player2Sixes;
        this.player1Bonus = player1Bonus;
        this.player2Bonus = player2Bonus;
        this.player1Upper = player1Upper;
        this.player2Upper = player2Upper;
        this.inTurn = inTurn;
    }

    private void refreshedText(JLabel label, Human player, int index) {
        if (player.getScore(index) != -1) {
            label.setText("" + player.getScore(index));
        } else {
            label.setText("0");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        rerollButton.setEnabled(false);
        game.rerollDice();
        die1.setText("" + dice.get(0).getValue());
        die2.setText("" + dice.get(1).getValue());
        die3.setText("" + dice.get(2).getValue());
        die4.setText("" + dice.get(3).getValue());
        die5.setText("" + dice.get(4).getValue());
        inTurn.setText("" + game.playerInTurn().getName());
        refreshedText(player1Ones, player1, 7);
        refreshedText(player2Ones, player2, 7);
        refreshedText(player1Twos, player1, 8);
        refreshedText(player2Twos, player2, 8);
        refreshedText(player1ThreesUp, player1, 9);
        refreshedText(player2ThreesUp, player2, 9);
        refreshedText(player1FoursUp, player1, 10);
        refreshedText(player2FoursUp, player2, 10);
        refreshedText(player1Fives, player1, 11);
        refreshedText(player2Fives, player2, 11);
        refreshedText(player1Sixes, player1, 12);
        refreshedText(player2Sixes, player2, 12);
        player1Bonus.setText("" + player1.upperSectionBonus());
        player2Bonus.setText("" + player2.upperSectionBonus());
        player1Upper.setText("" + player1.getUpperSectionScore());
        player2Upper.setText("" + player2.getUpperSectionScore());
        refreshedText(player1Pair, player1, 5);
        refreshedText(player2Pair, player2, 5);
        refreshedText(player1TwoPairs, player1, 4);
        refreshedText(player2TwoPairs, player2, 4);
        refreshedText(player1Threes, player1, 3);
        refreshedText(player2Threes, player2, 3);
        refreshedText(player1Fours, player1, 2);
        refreshedText(player2Fours, player2, 2);
        refreshedText(player1FullHouse, player1, 1);
        refreshedText(player2FullHouse, player2, 1);
        refreshedText(player1Sum, player1, 6);
        refreshedText(player2Sum, player2, 6);
        refreshedText(player1Yatzy, player1, 0);
        refreshedText(player2Yatzy, player2, 0);
        player1Total.setText("" + player1.getTotalScore());
        player2Total.setText("" + player2.getTotalScore());
        die1Button.setEnabled(true);
        die2Button.setEnabled(true);
        die3Button.setEnabled(true);
        die4Button.setEnabled(true);
        die5Button.setEnabled(true);
        doneRolling.setEnabled(false);
        scoreButton.setEnabled(true);
    }
}
