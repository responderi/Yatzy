package yatzy.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import yatzy.gui.listeners.info.InfoListener;
import yatzy.gui.listeners.scoring.*;
import yatzy.logic.game.*;
import yatzy.logic.scoring.*;
import yatzy.logic.player.*;
import yatzy.logic.dice.*;

public class InfoScreenGUI implements Runnable {

    private JFrame frame;

    public InfoScreenGUI() {
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy - How to play");
        frame.setPreferredSize(new Dimension(610, 180));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.add(infoMenu());
    }

    private JPanel infoMenu() {
        JPanel panel = new JPanel(new GridLayout(6, 1));
        JButton infoButton = new JButton("Understood!");
        JLabel infoText = new JLabel("How to play:");
        JLabel infoTextSecond = new JLabel("You will start the game by pressing 'Start' button.");
        JLabel infoTextThird = new JLabel("If you want to reroll some of the dice, reroll them by pressing specific die buttons and then 'Done rolling'.");
        JLabel infoTextFourth = new JLabel("If you haven't chosen to score earlier, you will be forced to score after two rerolls.");
        JLabel infoTextFifth = new JLabel("Scores and player in turn (text left to 'Start/End turn' text) will update after 'End turn' is pressed.");
        InfoListener infoListener = new InfoListener(frame);
        infoButton.addActionListener(infoListener);
        panel.add(infoText);
        panel.add(infoTextSecond);
        panel.add(infoTextThird);
        panel.add(infoTextFourth);
        panel.add(infoTextFifth);
        panel.add(infoButton);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
    
}