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
public class FoursUpperListener implements ActionListener {

    public Game game;
    public Score score;
    public Human player;
    public JFrame frame;
    public JButton button;
    
    public FoursUpperListener(Game game, Score score, Human player, JFrame frame, JButton button) {
        this.game = game;
        this.score = score;
        this.player = player;
        this.frame = frame;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        score.counting(player, game, 11);
        game.changeTurn();
        button.setEnabled(true);
        frame.dispose();
    }
}
