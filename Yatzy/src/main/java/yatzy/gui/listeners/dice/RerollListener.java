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
        player1Ones.setText("" + "" + player1.getScore(7));
        player2Ones.setText("" + "" + player2.getScore(7));
        player1Twos.setText("" + "" + player1.getScore(8));
        player2Twos.setText("" + "" + player2.getScore(8));
        player1ThreesUp.setText("" + "" + player1.getScore(9));
        player2ThreesUp.setText("" + "" + player2.getScore(9));
        player1FoursUp.setText("" + "" + player1.getScore(10));
        player2FoursUp.setText("" + "" + player2.getScore(10));
        player1Fives.setText("" + "" + player1.getScore(11));
        player2Fives.setText("" + "" + player2.getScore(11));
        player1Sixes.setText("" + "" + player1.getScore(12));
        player2Sixes.setText("" + "" + player2.getScore(12));
        player1Bonus.setText("" + "" + player1.upperSectionBonus());
        player2Bonus.setText("" + "" + player2.upperSectionBonus());
        player1Upper.setText("" + "" + player1.getUpperSectionScore());
        player2Upper.setText("" + "" + player2.getUpperSectionScore());
        player1Pair.setText("" + "" + player1.getScore(5));
        player2Pair.setText("" + "" + player2.getScore(5));
        player1TwoPairs.setText("" + "" + player1.getScore(4));
        player2TwoPairs.setText("" + "" + player2.getScore(4));
        player1Threes.setText("" + "" + player1.getScore(3));
        player2Threes.setText("" + "" + player2.getScore(3));
        player1Fours.setText("" + "" + player1.getScore(2));
        player2Fours.setText("" + "" + player2.getScore(2));
        player1FullHouse.setText("" + "" + player1.getScore(1));
        player2FullHouse.setText("" + "" + player2.getScore(1));
        player1Sum.setText("" + "" + player1.getScore(6));
        player2Sum.setText("" + "" + player2.getScore(6));
        player1Yatzy.setText("" + "" + player1.getScore(0));
        player2Yatzy.setText("" + "" + player2.getScore(0));
        player1Total.setText("" + "" + player1.getTotalScore());
        player2Total.setText("" + "" + player2.getTotalScore());
        die1Button.setEnabled(true);
        die2Button.setEnabled(true);
        die3Button.setEnabled(true);
        die4Button.setEnabled(true);
        die5Button.setEnabled(true);
        doneRolling.setEnabled(true);
        scoreButton.setEnabled(true);
    }
}
