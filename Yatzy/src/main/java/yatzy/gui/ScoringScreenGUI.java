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
    public JButton button;

    public ScoringScreenGUI(Game game, Score score, Human player1, Human player2, ArrayList<Dice> dice, JButton button) {
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        this.dice = dice;
        this.score = score;
        this.button = button;
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy - Scoring");
        frame.setPreferredSize(new Dimension(250, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.add(diceMenu(), BorderLayout.NORTH);
        container.add(scoringMenu(), BorderLayout.SOUTH);
    }

    private JPanel diceMenu() {
        JPanel panel = new JPanel(new GridLayout(1, 5));
        JLabel dieLabel1 = new JLabel("" + dice.get(0).getValue());
        JLabel dieLabel2 = new JLabel("" + dice.get(1).getValue());
        JLabel dieLabel3 = new JLabel("" + dice.get(2).getValue());
        JLabel dieLabel4 = new JLabel("" + dice.get(3).getValue());
        JLabel dieLabel5 = new JLabel("" + dice.get(4).getValue());
        panel.add(dieLabel1);
        panel.add(dieLabel2);
        panel.add(dieLabel3);
        panel.add(dieLabel4);
        panel.add(dieLabel5);
        return panel;
    }
    
    private JPanel scoringMenu() {
        JPanel panel = new JPanel(new GridLayout(13, 2));
        JButton oneButton = new JButton("Score");
        JButton twoButton = new JButton("Score");
        JButton threeButton = new JButton("Score");
        JButton fourButton = new JButton("Score");
        JButton fiveButton = new JButton("Score");
        JButton sixButton = new JButton("Score");
        JButton pairButton = new JButton("Score");
        JButton twoPairsButton = new JButton("Score");
        JButton threesButton = new JButton("Score");
        JButton foursButton = new JButton("Score");
        JButton fullHouseButton = new JButton("Score");
        JButton sumButton = new JButton("Score");
        JButton yatzyButton = new JButton("Score");
        JLabel oneText = new JLabel("Ones");
        JLabel twoText = new JLabel("Twos");
        JLabel threeText = new JLabel("Threes");
        JLabel fourText = new JLabel("Fours");
        JLabel fiveText = new JLabel("Fives");
        JLabel sixText = new JLabel("Sixes");
        JLabel pairText = new JLabel("A pair");
        JLabel twoPairsText = new JLabel("Two pairs");
        JLabel threesText = new JLabel("Three of a kind");
        JLabel foursText = new JLabel("Four of a kind");
        JLabel fullHouseText = new JLabel("Full House");
        JLabel sumText = new JLabel("Sum");
        JLabel yatzyText = new JLabel("Yatzy");
        OnesUpperListener oneListener = new OnesUpperListener(game, score, game.playerInTurn(), frame, button);
        TwosUpperListener twoListener = new TwosUpperListener(game, score, game.playerInTurn(), frame, button);
        ThreesUpperListener threeListener = new ThreesUpperListener(game, score, game.playerInTurn(), frame, button);
        FoursUpperListener fourListener = new FoursUpperListener(game, score, game.playerInTurn(), frame, button);
        FivesUpperListener fiveListener = new FivesUpperListener(game, score, game.playerInTurn(), frame, button);
        SixesUpperListener sixListener = new SixesUpperListener(game, score, game.playerInTurn(), frame, button);
        PairListener pairListener = new PairListener(game, score, game.playerInTurn(), frame, button);
        TwoPairListener twoPairListener = new TwoPairListener(game, score, game.playerInTurn(), frame, button);
        ThreesListener threesListener = new ThreesListener(game, score, game.playerInTurn(), frame, button);
        FoursListener foursListener = new FoursListener(game, score, game.playerInTurn(), frame, button);
        FullHouseListener fullHouseListener = new FullHouseListener(game, score, game.playerInTurn(), frame, button);
        SumListener sumListener = new SumListener(game, score, game.playerInTurn(), frame, button);
        YatzyListener yatzyListener = new YatzyListener(game, score, game.playerInTurn(), frame, button);
        oneButton.addActionListener(oneListener);
        twoButton.addActionListener(twoListener);
        threeButton.addActionListener(threeListener);
        fourButton.addActionListener(fourListener);
        fiveButton.addActionListener(fiveListener);
        sixButton.addActionListener(sixListener);
        pairButton.addActionListener(pairListener);
        twoPairsButton.addActionListener(twoPairListener);
        threesButton.addActionListener(threesListener);
        foursButton.addActionListener(foursListener);
        fullHouseButton.addActionListener(fullHouseListener);
        sumButton.addActionListener(sumListener);
        yatzyButton.addActionListener(yatzyListener);
        checkIfScored(oneButton, 7);
        checkIfScored(twoButton, 8);
        checkIfScored(threeButton, 9);
        checkIfScored(fourButton, 10);
        checkIfScored(fiveButton, 11);
        checkIfScored(sixButton, 12);
        checkIfScored(pairButton, 5);
        checkIfScored(twoPairsButton, 4);
        checkIfScored(threesButton, 3);
        checkIfScored(foursButton, 2);
        checkIfScored(fullHouseButton, 1);
        checkIfScored(sumButton, 6);
        checkIfScored(yatzyButton, 0);
        panel.add(oneButton);
        panel.add(oneText);
        panel.add(twoButton);
        panel.add(twoText);
        panel.add(threeButton);
        panel.add(threeText);
        panel.add(fourButton);
        panel.add(fourText);
        panel.add(fiveButton);
        panel.add(fiveText);
        panel.add(sixButton);
        panel.add(sixText);
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
    
    public void checkIfScored(JButton button, int index) {
        if (game.playerInTurn().getScore(index) != -1) {
            button.setEnabled(false);
        }
    }
    
}