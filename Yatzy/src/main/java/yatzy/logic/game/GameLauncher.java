package yatzy.logic.game;

import java.util.ArrayList;
import yatzy.logic.scoring.*;
import javax.swing.*;
import yatzy.gui.*;
import yatzy.logic.dice.Dice;
import yatzy.logic.player.Human;

/**
 * This class is used to launch the game.
 *
 * @author responderi Creator of the project
 */
public class GameLauncher {

    /**
     * This method is used to start the game.
     * 
     * @param args parameter
     * @throws Exception throws execption in unexpected situation
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Dice> dice = new ArrayList<>();
        Human player1 = new Human("player1");
        Human player2 = new Human("player2");
        Score newScore = new Score();
        Game newGame = new Game(newScore, player1, player2, dice);
        GameScreenGUI gui = new GameScreenGUI(newGame, player1, player2, dice, newScore);
        SwingUtilities.invokeLater(gui);
    }
}
