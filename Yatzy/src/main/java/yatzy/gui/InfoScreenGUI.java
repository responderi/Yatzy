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
        frame.setPreferredSize(new Dimension(590, 210));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.add(infoMenu());
    }

    private JPanel infoMenu() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JButton infoButton = new JButton("Understood!");
        JTextArea infoText = new JTextArea("How to play:\n You will start your turn by pressing 'Reroll' button.\n If you want to reroll some of the dice, reroll them by pressing specific die buttons and then 'Done rolling'.\n If you havent chosen to score earlier, you will be forced to score after two reroll times.\n Scores and player in turn (left to 'Player 1' text) will update always after one's first reroll-button push.");
        InfoListener infoListener = new InfoListener(frame);
        infoButton.addActionListener(infoListener);
        infoText.setEnabled(false);
        panel.add(infoText);
        panel.add(infoButton);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
    
}