package yatzy.gui;

import yatzy.gui.listeners.dice.DoneRollingListener;
import yatzy.gui.listeners.dice.RerollListener;
import yatzy.gui.listeners.dice.DiceFourListener;
import yatzy.gui.listeners.dice.DiceFiveListener;
import yatzy.gui.listeners.dice.DiceThreeListener;
import yatzy.gui.listeners.dice.DiceTwoListener;
import yatzy.gui.listeners.dice.DiceOneListener;
import yatzy.gui.listeners.dice.ScoreListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import yatzy.logic.game.*;
import yatzy.logic.scoring.*;
import yatzy.logic.player.*;
import yatzy.logic.dice.*;

public class GameScreenGUI implements Runnable {

    private JFrame frame;
    public JTable jTable1;
    public Game game;
    public Score score;
    public ArrayList<Dice> dice;
    public Human player1, player2;
    
    public GameScreenGUI(Game game, Human player1, Human player2, ArrayList<Dice> dice, Score score) {
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        this.dice = dice;
        this.score = score;
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy");
        frame.setPreferredSize(new Dimension(525, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        InfoScreenGUI info = new InfoScreenGUI();
        SwingUtilities.invokeLater(info);
    }

    private void createComponents(Container container) {
        JPanel panelStats = new JPanel(new GridLayout(17, 3));
        JLabel empty = new JLabel("");
        JLabel player1Text = new JLabel("Player 1", SwingConstants.CENTER);
        JLabel player2Text = new JLabel("Player 2", SwingConstants.CENTER);
        JLabel ones = new JLabel("1", SwingConstants.RIGHT);
        JLabel player1Ones = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Ones = new JLabel("0", SwingConstants.CENTER);
        JLabel twos = new JLabel("2", SwingConstants.RIGHT);
        JLabel player1Twos = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Twos = new JLabel("0", SwingConstants.CENTER);
        JLabel threes = new JLabel("3", SwingConstants.RIGHT);
        JLabel player1ThreesUp = new JLabel("0", SwingConstants.CENTER);
        JLabel player2ThreesUp = new JLabel("0", SwingConstants.CENTER);
        JLabel fours = new JLabel("4", SwingConstants.RIGHT);
        JLabel player1FoursUp = new JLabel("0", SwingConstants.CENTER);
        JLabel player2FoursUp = new JLabel("0", SwingConstants.CENTER);
        JLabel fives = new JLabel("5", SwingConstants.RIGHT);
        JLabel player1Fives = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Fives = new JLabel("0", SwingConstants.CENTER);
        JLabel sixes = new JLabel("6", SwingConstants.RIGHT);
        JLabel player1Sixes = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Sixes = new JLabel("0", SwingConstants.CENTER);
        JLabel bonus = new JLabel("Bonus (63 requird)", SwingConstants.RIGHT);
        JLabel player1Bonus = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Bonus = new JLabel("0", SwingConstants.CENTER);
        JLabel upperTotal = new JLabel("Upper score:", SwingConstants.RIGHT);
        JLabel player1Upper = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Upper = new JLabel("0", SwingConstants.CENTER);
        JLabel pairText = new JLabel("A pair", SwingConstants.RIGHT);
        JLabel twoPairsText = new JLabel("Two pairs", SwingConstants.RIGHT);
        JLabel threesText = new JLabel("Three of a kind", SwingConstants.RIGHT);
        JLabel foursText = new JLabel("Four of a kind", SwingConstants.RIGHT);
        JLabel fullHouseText = new JLabel("Full House", SwingConstants.RIGHT);
        JLabel sumText = new JLabel("Sum", SwingConstants.RIGHT);
        JLabel yatzyText = new JLabel("Yatzy", SwingConstants.RIGHT);
        JLabel totalScoreText = new JLabel("Total score", SwingConstants.RIGHT);
        JLabel player1Pair = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Pair = new JLabel("0", SwingConstants.CENTER);
        JLabel player1TwoPairs = new JLabel("0", SwingConstants.CENTER);
        JLabel player2TwoPairs = new JLabel("0", SwingConstants.CENTER);
        JLabel player1Threes = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Threes = new JLabel("0", SwingConstants.CENTER);
        JLabel player1Fours = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Fours = new JLabel("0", SwingConstants.CENTER);
        JLabel player1FullHouse = new JLabel("0", SwingConstants.CENTER);
        JLabel player2FullHouse = new JLabel("0", SwingConstants.CENTER);
        JLabel player1Sum = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Sum = new JLabel("0", SwingConstants.CENTER);
        JLabel player1Yatzy = new JLabel("0", SwingConstants.CENTER);
        JLabel player2Yatzy = new JLabel("0", SwingConstants.CENTER);
        JLabel player1Total = new JLabel("" + player1.getTotalScore(), SwingConstants.CENTER);
        JLabel player2Total = new JLabel("" + player2.getTotalScore(), SwingConstants.CENTER);
        panelStats.add(empty);
        panelStats.add(player1Text);
        panelStats.add(player2Text);
        panelStats.add(ones);
        panelStats.add(player1Ones);
        panelStats.add(player2Ones);
        panelStats.add(twos);
        panelStats.add(player1Twos);
        panelStats.add(player2Twos);
        panelStats.add(threes);
        panelStats.add(player1ThreesUp);
        panelStats.add(player2ThreesUp);
        panelStats.add(fours);
        panelStats.add(player1FoursUp);
        panelStats.add(player2FoursUp);
        panelStats.add(fives);
        panelStats.add(player1Fives);
        panelStats.add(player2Fives);
        panelStats.add(sixes);
        panelStats.add(player1Sixes);
        panelStats.add(player2Sixes);
        panelStats.add(bonus);
        panelStats.add(player1Bonus);
        panelStats.add(player2Bonus);
        panelStats.add(upperTotal);
        panelStats.add(player1Upper);
        panelStats.add(player2Upper);
        panelStats.add(pairText);
        panelStats.add(player1Pair);
        panelStats.add(player2Pair);
        panelStats.add(twoPairsText);
        panelStats.add(player1TwoPairs);
        panelStats.add(player2TwoPairs);
        panelStats.add(threesText);
        panelStats.add(player1Threes);
        panelStats.add(player2Threes);
        panelStats.add(foursText);
        panelStats.add(player1Fours);
        panelStats.add(player2Fours);
        panelStats.add(fullHouseText);
        panelStats.add(player1FullHouse);
        panelStats.add(player2FullHouse);
        panelStats.add(sumText);
        panelStats.add(player1Sum);
        panelStats.add(player2Sum);
        panelStats.add(yatzyText);
        panelStats.add(player1Yatzy);
        panelStats.add(player2Yatzy);
        panelStats.add(totalScoreText);
        panelStats.add(player1Total);
        panelStats.add(player2Total);
        JPanel panel = new JPanel(new GridLayout(3, 5));
        JLabel dieLabel1 = new JLabel("" + dice.get(0).getValue(), SwingConstants.CENTER);
        JLabel dieLabel2 = new JLabel("" + dice.get(1).getValue(), SwingConstants.CENTER);
        JLabel dieLabel3 = new JLabel("" + dice.get(2).getValue(), SwingConstants.CENTER);
        JLabel dieLabel4 = new JLabel("" + dice.get(3).getValue(), SwingConstants.CENTER);
        JLabel dieLabel5 = new JLabel("" + dice.get(4).getValue(), SwingConstants.CENTER);
        JButton die1 = new JButton("Roll");
        JButton die2 = new JButton("Roll");
        JButton die3 = new JButton("Roll");
        JButton die4 = new JButton("Roll");
        JButton die5 = new JButton("Roll");
        JLabel inTurn = new JLabel("" + game.playerInTurn().getName(), SwingConstants.CENTER);
        inTurn.setForeground(Color.red);
        JButton rerollButton = new JButton("Start");
        JButton doneRolling = new JButton("Done rolling");
        JButton scoreButton = new JButton("Score");
        JLabel emptyThird = new JLabel("");
        die1.setEnabled(false);
        die2.setEnabled(false);
        die3.setEnabled(false);
        die4.setEnabled(false);
        die5.setEnabled(false);
        doneRolling.setEnabled(false);
        scoreButton.setEnabled(false);
        DiceOneListener listener1 = new DiceOneListener(dice, game, die1, doneRolling, scoreButton);
        DiceTwoListener listener2 = new DiceTwoListener(dice, game, die2, doneRolling, scoreButton);
        DiceThreeListener listener3 = new DiceThreeListener(dice, game, die3, doneRolling, scoreButton);
        DiceFourListener listener4 = new DiceFourListener(dice, game, die4, doneRolling, scoreButton);
        DiceFiveListener listener5 = new DiceFiveListener(dice, game, die5, doneRolling, scoreButton);
        RerollListener rerollListener = new RerollListener(rerollButton, die1, die2, die3, die4, die5, doneRolling, this, game, dieLabel1, dieLabel2, dieLabel3, dieLabel4, dieLabel5, dice, player1Pair, player2Pair, player1TwoPairs, player2TwoPairs, player1Threes, player2Threes, player1Fours, player2Fours, player1FullHouse, player2FullHouse, player1Sum, player2Sum, player1Yatzy, player2Yatzy, player1Total, player2Total, player1, player2, scoreButton, player1Ones, player2Ones, player1Twos, player2Twos, player1ThreesUp, player2ThreesUp, player1FoursUp, player2FoursUp, player1Fives, player2Fives, player1Sixes, player2Sixes, player1Bonus, player2Bonus, player1Upper, player2Upper, inTurn);
        ScoreListener scoreListener = new ScoreListener(scoreButton, rerollButton, die1, die2, die3, die4, die5, score, game, player1, player2, doneRolling, dice, dieLabel1, dieLabel2, dieLabel3, dieLabel4, dieLabel5);
        DoneRollingListener doneListener = new DoneRollingListener(dieLabel1, dieLabel2, dieLabel3, dieLabel4, dieLabel5, dice, game, score, player1, player2, rerollButton, die1, die2, die3, die4, die5, doneRolling, scoreButton);
        die1.addActionListener(listener1);
        die2.addActionListener(listener2);
        die3.addActionListener(listener3);
        die4.addActionListener(listener4);
        die5.addActionListener(listener5);
        rerollButton.addActionListener(rerollListener);
        scoreButton.addActionListener(scoreListener);
        doneRolling.addActionListener(doneListener);
        panel.add(dieLabel1);
        panel.add(dieLabel2);
        panel.add(dieLabel3);
        panel.add(dieLabel4);
        panel.add(dieLabel5);
        panel.add(die1);
        panel.add(die2);
        panel.add(die3);
        panel.add(die4);
        panel.add(die5);
        panel.add(inTurn);
        panel.add(rerollButton);
        panel.add(doneRolling);
        panel.add(scoreButton);
        panel.add(emptyThird);
        container.add(panelStats, BorderLayout.SOUTH);
        container.add(panel, BorderLayout.NORTH);
    }

    public JFrame getFrame() {
        return frame;
    }

}
