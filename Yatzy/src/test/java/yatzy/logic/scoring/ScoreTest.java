package yatzy.logic.scoring;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.logic.game.*;
import java.util.*;
import java.io.*;
import yatzy.logic.player.Human;
import yatzy.logic.game.*;
import yatzy.logic.dice.*;
import yatzy.logic.scoring.*;

/**
 *
 * @author responderi
 */
public class ScoreTest {

    public ScoreTest() {
    }

    Score testScore;
    Game testGame;
    Human player1;
    Human player2;
    ArrayList<Dice> dice;

    @Before
    public void setUp() {
        player1 = new Human("player1");
        player2 = new Human("player2");
        testScore = new Score();
        testGame = new Game(testScore);
        dice = new ArrayList<>();
    }

    @Test
    public void countingWorks() {
        testGame.initializeDice();
        String simulatedUserInput = "7" + System.getProperty("line.separator");

        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        testScore.counting(player1, testGame);
        
        System.setIn(savedStandardInputStream);
        assertEquals(player1.getScore(6), 15);
    }

}
