package yatzy.gui.listeners.scoring;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import yatzy.logic.dice.Dice;
import yatzy.logic.game.*;
import yatzy.logic.player.Human;
import yatzy.logic.scoring.Score;
import yatzy.gui.*;

/**
 *
 * @author Roni
 */
public class PairListener implements ActionListener {

    private Game game;
    private Score score;
    private JLabel pair;
    private Human player;
    
    public PairListener(Game game, Score score, JLabel pair, Human player) {
        this.game = game;
        this.score = score;
        this.pair = pair;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        score.counting(player, game, 6);
    }
}
