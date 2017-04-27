package yatzy.logic.game;

import yatzy.logic.scoring.*;
import javax.swing.*;
import yatzy.gui.*;

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
        StartGameGUI game = new StartGameGUI();
        game.setVisible(true);
    }
}
