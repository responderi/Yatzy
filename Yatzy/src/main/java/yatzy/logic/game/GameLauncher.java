package yatzy.logic.game;

import yatzy.logic.scoring.*;
import javax.swing.*;
import yatzy.gui.*;

/**
 *
 * @author responderi
 */
public class GameLauncher {

    public static void main(String[] args) throws Exception {
        Score newScore = new Score();
        Game newGame = new Game(newScore);
        StartGame startGame = new StartGame();
        SwingUtilities.invokeLater(startGame);
        newGame.playGame();
    }
}
