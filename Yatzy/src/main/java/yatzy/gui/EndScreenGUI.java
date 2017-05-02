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
import yatzy.gui.listeners.end.EndListener;
import yatzy.logic.game.*;
import yatzy.logic.scoring.*;
import yatzy.logic.player.*;
import yatzy.logic.dice.*;

public class EndScreenGUI implements Runnable {

    private JFrame frame;
    public JTable jTable1;
    public Game game;
    public Score score;
    public ArrayList<Dice> dice;
    public Human player1, player2;

    public EndScreenGUI(Game game, Human player1, Human player2, ArrayList<Dice> dice, Score score) {
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        this.dice = dice;
        this.score = score;
    }

    @Override
    public void run() {
        frame = new JFrame("Game over!");
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(resultMenu());
        JButton exitButton = new JButton("Exit");
        EndListener endGame = new EndListener();
        exitButton.addActionListener(endGame);
    }

    private JPanel resultMenu() {
        JPanel panel = new JPanel(new GridLayout(3,3));
        JLabel playersText = new JLabel("Players:");
        JLabel player1Text = new JLabel("" + player1.getName());
        JLabel player2Text = new JLabel("" + player2.getName());
        JLabel scores = new JLabel("Final scores:");
        JLabel player1Total = new JLabel("" + player1.getTotalScore());
        JLabel player2Total = new JLabel("" + player2.getTotalScore());
        JLabel winner = new JLabel("Winner:");
        JLabel gameWinner = new JLabel("" + game.winner());
        JLabel empty = new JLabel("");
        panel.add(playersText);
        panel.add(player1Text);
        panel.add(player2Text);
        panel.add(scores);
        panel.add(player1Total);
        panel.add(player2Total);
        panel.add(winner);
        panel.add(gameWinner);
        panel.add(empty);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

}