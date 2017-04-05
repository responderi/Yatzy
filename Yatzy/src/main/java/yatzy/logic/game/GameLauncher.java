package yatzy.logic.game;

import yatzy.logic.scoring.*;
import javax.swing.*;

/**
 *
 * @author responderi
 */
public class GameLauncher {

    public static void main(String[] args) throws Exception {
        Score newScore = new Score();
        Game newGame = new Game(newScore);
        newGame.playGame();
    }
}
