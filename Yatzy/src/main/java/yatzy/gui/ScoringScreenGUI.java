package yatzy.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import yatzy.gui.listeners.scoring.*;
import yatzy.logic.game.*;
import yatzy.logic.scoring.*;
import yatzy.logic.player.*;
import yatzy.logic.dice.*;

public class ScoringScreenGUI implements Runnable {

    private JFrame frame;
    public Game game;
    public Score score;
    public ArrayList<Dice> dice;
    public Human player1, player2;

    public ScoringScreenGUI(Game game, Score score, Human player1, Human player2, ArrayList<Dice> dice) {
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        this.dice = dice;
        this.score = score;
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy - Scoring");
        frame.setPreferredSize(new Dimension(250, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(scoringMenu());
    }

    private JPanel scoringMenu() {
        JPanel panel = new JPanel(new GridLayout(7, 2));        
        JButton pairButton = new JButton("Score");
        JButton twoPairsButton = new JButton("Score");
        JButton threesButton = new JButton("Score");
        JButton foursButton = new JButton("Score");
        JButton fullHouseButton = new JButton("Score");
        JButton sumButton = new JButton("Score");
        JButton yatzyButton = new JButton("Score");
        JLabel pairText = new JLabel("A pair");
        JLabel twoPairsText = new JLabel("Two pairs");
        JLabel threesText = new JLabel("Three of a kind");
        JLabel foursText = new JLabel("Four of a kind");
        JLabel fullHouseText = new JLabel("Full House");
        JLabel sumText = new JLabel("Sum");
        JLabel yatzyText = new JLabel("Yatzy");
        PairListener pairListener = new PairListener(game, score, game.playerInTurn(), frame);
        TwoPairListener twoPairListener = new TwoPairListener(game, score, game.playerInTurn(), frame);
        ThreesListener threesListener = new ThreesListener(game, score, game.playerInTurn(), frame);
        FoursListener foursListener = new FoursListener(game, score, game.playerInTurn(), frame);
        FullHouseListener fullHouseListener = new FullHouseListener(game, score, game.playerInTurn(), frame);
        SumListener sumListener = new SumListener(game, score, game.playerInTurn(), frame);
        YatzyListener yatzyListener = new YatzyListener(game, score, game.playerInTurn(), frame);
        pairButton.addActionListener(pairListener);
        twoPairsButton.addActionListener(twoPairListener);
        threesButton.addActionListener(threesListener);
        foursButton.addActionListener(foursListener);
        fullHouseButton.addActionListener(fullHouseListener);
        sumButton.addActionListener(sumListener);
        yatzyButton.addActionListener(yatzyListener);
        panel.add(pairButton);
        panel.add(pairText);
        panel.add(twoPairsButton);
        panel.add(twoPairsText);
        panel.add(threesButton);
        panel.add(threesText);
        panel.add(foursButton);
        panel.add(foursText);
        panel.add(fullHouseButton);
        panel.add(fullHouseText);
        panel.add(sumButton);
        panel.add(sumText);
        panel.add(yatzyButton);
        panel.add(yatzyText);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}