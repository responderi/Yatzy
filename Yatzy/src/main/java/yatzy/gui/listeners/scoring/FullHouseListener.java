package yatzy.gui.listeners.scoring;

import java.awt.event.*;
import javax.swing.*;
import yatzy.logic.game.*;
import yatzy.logic.player.Human;
import yatzy.logic.scoring.Score;

/**
 *
 * @author Roni
 */
public class FullHouseListener implements ActionListener {

    public Game game;
    public Score score;
    public Human player;
    public JFrame frame;
    public JButton button;
    
    public FullHouseListener(Game game, Score score, Human player, JFrame frame, JButton button) {
        this.game = game;
        this.score = score;
        this.player = player;
        this.frame = frame;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        score.counting(player, game, 2);
        game.changeTurn();
        button.setEnabled(true);
        frame.dispose();
    }
}