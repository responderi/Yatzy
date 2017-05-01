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
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new javax.swing.JTable();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {"A pair", player1.getScore(5), player2.getScore(5)},
                    {"Two pairs", player1.getScore(4), player2.getScore(4)},
                    {"Three of a kind", player1.getScore(3), player2.getScore(3)},
                    {"Four of a kind", player1.getScore(2), player2.getScore(2)},
                    {"Full House", player1.getScore(1), player2.getScore(1)},
                    {"Sum", player1.getScore(6), player2.getScore(6)},
                    {"Yahtzee", player1.getScore(0), player2.getScore(0)},
                    {"Total score", player1.getTotalScore(), player2.getTotalScore()}
                },
                new String[]{
                    "", "Player 1", "Player 2"
                }
        ));
        jScrollPane1.setViewportView(jTable1);
        jTable1.setEnabled(false);
        container.add(diceMenu(), BorderLayout.NORTH);
        container.add(jScrollPane1, BorderLayout.CENTER);
    }

    private JPanel diceMenu() {
        JPanel panel = new JPanel(new GridLayout(3, 5));
        JTextArea dieLabel1 = new JTextArea("" + dice.get(0).getValue());
        JTextArea dieLabel2 = new JTextArea("" + dice.get(1).getValue());
        JTextArea dieLabel3 = new JTextArea("" + dice.get(2).getValue());
        JTextArea dieLabel4 = new JTextArea("" + dice.get(3).getValue());
        JTextArea dieLabel5 = new JTextArea("" + dice.get(4).getValue());
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
        dieLabel1.setEnabled(false);
        dieLabel2.setEnabled(false);
        dieLabel3.setEnabled(false);
        dieLabel4.setEnabled(false);
        dieLabel5.setEnabled(false);
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
        RerollListener rerollListener = new RerollListener(rerollButton, die1, die2, die3, die4, die5, doneRolling);
        ScoreListener scoreListener = new ScoreListener(scoreButton, rerollButton, die1, die2, die3, die4, die5, score, game, game.playerInTurn(), doneRolling, dice);
        DoneRollingListener doneListener = new DoneRollingListener(dieLabel1, dieLabel2, dieLabel3, dieLabel4, dieLabel5, dice, game, score, game.playerInTurn());
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
