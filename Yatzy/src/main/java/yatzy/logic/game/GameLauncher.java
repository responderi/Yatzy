package yatzy.logic.game;

import yatzy.logic.scoring.*;

/**
 *
 * @author responderi
 */
public class GameLauncher {

    public static void main(String[] args) {
        Score newScore = new Score();
        Game newGame = new Game(newScore);
        newGame.playGame();
    }
}
