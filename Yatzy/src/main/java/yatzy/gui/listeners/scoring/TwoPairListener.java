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
public class TwoPairListener implements ActionListener {

    public Game game;
    public Score score;
    public Human player;
    public JFrame frame;
    
    public TwoPairListener(Game game, Score score, Human player, JFrame frame) {
        this.game = game;
        this.score = score;
        this.player = player;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        score.counting(player, game, 5);
        game.changeTurn();
        frame.dispose();
    }
}