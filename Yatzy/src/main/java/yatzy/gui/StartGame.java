package yatzy.gui;

/**
 *
 * @author responderi
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import yatzy.logic.player.*;
import yatzy.logic.game.*;

public class StartGame implements Runnable {

    private JFrame frame;

    public StartGame() {
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy");
        frame.setPreferredSize(new Dimension(600, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initializeComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void initializeComponents(Container container) {
        JButton rollButton = new JButton("Start game (currently no action here, do not close this window in order to play in console)");
        container.add(rollButton);
    }

    public JFrame getFrame() {
        return frame;
    }
}
