package yatzy.gui.listeners.end;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import yatzy.logic.game.Game;
import yatzy.logic.player.Human;
import yatzy.logic.scoring.Score;

/**
 *
 * @author Roni
 */
public class EndListener implements ActionListener {

    public EndListener() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
}
