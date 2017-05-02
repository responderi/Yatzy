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
        frame.setPreferredSize(new Dimension(400, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
//        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
//        jTable1 = new javax.swing.JTable();
//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//                new Object[][]{
//                    {"A pair", player1.getScore(5), player2.getScore(5)},
//                    {"Two pairs", player1.getScore(4), player2.getScore(4)},
//                    {"Three of a kind", player1.getScore(3), player2.getScore(3)},
//                    {"Four of a kind", player1.getScore(2), player2.getScore(2)},
//                    {"Full House", player1.getScore(1), player2.getScore(1)},
//                    {"Sum", player1.getScore(6), player2.getScore(6)},
//                    {"Yahtzee", player1.getScore(0), player2.getScore(0)},
//                    {"Total score", player1.getTotalScore(), player2.getTotalScore()}
//                },
//                new String[]{
//                    "", "Player 1", "Player 2"
//                }
//        ));
//        jScrollPane1.setViewportView(jTable1);
//        jTable1.setEnabled(false);
        container.add(diceMenu(), BorderLayout.NORTH);
        container.add(resultMenu(), BorderLayout.SOUTH);
//        container.add(jScrollPane1, BorderLayout.CENTER);
    }

    private JPanel resultMenu() {
        JPanel panel = new JPanel(new GridLayout(9,3));
        JLabel empty = new JLabel("");
        JLabel player1Text = new JLabel("Player 1");
        JLabel player2Text = new JLabel("Player 2");
        JLabel pairText = new JLabel("A pair");
        JLabel twoPairsText = new JLabel("Two pairs");
        JLabel threesText = new JLabel("Three of a kind");
        JLabel foursText = new JLabel("Four of a kind");
        JLabel fullHouseText = new JLabel("Full House");
        JLabel sumText = new JLabel("Sum");
        JLabel yatzyText = new JLabel("Yatzy");
        JLabel totalScoreText = new JLabel("Total score");
        JLabel player1Pair = new JLabel("" + player1.getScore(5));
        JLabel player2Pair = new JLabel("" + player2.getScore(5));
        JLabel player1TwoPairs = new JLabel("" + player1.getScore(4));
        JLabel player2TwoPairs = new JLabel("" + player2.getScore(4));
        JLabel player1Threes = new JLabel("" + player1.getScore(3));
        JLabel player2Threes = new JLabel("" + player2.getScore(3));
        JLabel player1Fours = new JLabel("" + player1.getScore(2));
        JLabel player2Fours = new JLabel("" + player2.getScore(2));
        JLabel player1FullHouse = new JLabel("" + player1.getScore(1));
        JLabel player2FullHouse = new JLabel("" + player2.getScore(1));
        JLabel player1Sum = new JLabel("" + player1.getScore(6));
        JLabel player2Sum = new JLabel("" + player2.getScore(6));
        JLabel player1Yatzy = new JLabel("" + player1.getScore(0));
        JLabel player2Yatzy = new JLabel("" + player2.getScore(0));
        JLabel player1Total = new JLabel("" + player1.getTotalScore());
        JLabel player2Total = new JLabel("" + player2.getTotalScore());
        panel.add(empty);
        panel.add(player1Text);
        panel.add(player2Text);
        panel.add(pairText);
        panel.add(player1Pair);
        panel.add(player2Pair);
        panel.add(twoPairsText);
        panel.add(player1TwoPairs);
        panel.add(player2TwoPairs);
        panel.add(threesText);
        panel.add(player1Threes);
        panel.add(player2Threes);
        panel.add(foursText);
        panel.add(player1Fours);
        panel.add(player2Fours);
        panel.add(fullHouseText);
        panel.add(player1FullHouse);
        panel.add(player2FullHouse);
        panel.add(sumText);
        panel.add(player1Sum);
        panel.add(player2Sum);
        panel.add(yatzyText);
        panel.add(player1Yatzy);
        panel.add(player2Yatzy);
        panel.add(totalScoreText);
        panel.add(player1Total);
        panel.add(player2Total);
        return panel;
    }
    
    private JPanel diceMenu() {
        JPanel panel = new JPanel(new GridLayout(3, 5));
        JLabel dieLabel1 = new JLabel("" + dice.get(0).getValue());
        JLabel dieLabel2 = new JLabel("" + dice.get(1).getValue());
        JLabel dieLabel3 = new JLabel("" + dice.get(2).getValue());
        JLabel dieLabel4 = new JLabel("" + dice.get(3).getValue());
        JLabel dieLabel5 = new JLabel("" + dice.get(4).getValue());
        JButton die1 = new JButton("Roll");
        JButton die2 = new JButton("Roll");
        JButton die3 = new JButton("Roll");
        JButton die4 = new JButton("Roll");
        JButton die5 = new JButton("Roll");
        JLabel emptyFirst = new JLabel("");
        JButton rerollButton = new JButton("Reroll");
        JButton doneRolling = new JButton("Done rolling.");
        JButton scoreButton = new JButton("Score");
        JLabel emptyThird = new JLabel("");
        die1.setEnabled(false);
        die2.setEnabled(false);
        die3.setEnabled(false);
        die4.setEnabled(false);
        die5.setEnabled(false);
        doneRolling.setEnabled(false);
        DiceOneListener listener1 = new DiceOneListener(dice, game);
        DiceTwoListener listener2 = new DiceTwoListener(dice, game);
        DiceThreeListener listener3 = new DiceThreeListener(dice, game);
        DiceFourListener listener4 = new DiceFourListener(dice, game);
        DiceFiveListener listener5 = new DiceFiveListener(dice, game);
        RerollListener rerollListener = new RerollListener(rerollButton, die1, die2, die3, die4, die5, doneRolling, jTable1);
        ScoreListener scoreListener = new ScoreListener(scoreButton, rerollButton, die1, die2, die3, die4, die5, score, game, player1, player2, doneRolling, dice);
        DoneRollingListener doneListener = new DoneRollingListener(dieLabel1, dieLabel2, dieLabel3, dieLabel4, dieLabel5, dice, game, score, player1, player2, rerollButton);
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
        panel.add(emptyFirst);
        panel.add(rerollButton);
        panel.add(doneRolling);
        panel.add(scoreButton);
        panel.add(emptyThird);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

}
