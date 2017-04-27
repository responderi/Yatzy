package yatzy.logic.scoring;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.logic.game.Game;

/**
 *
 * @author Roni
 */
public class HighScoreTest {

    public HighScoreTest() {
    }

    Score testScore;
    Game testGame;
    HighScore testHs;

    @Before
    public void setUp() {
        testScore = new Score();
        testGame = new Game(testScore);
        testHs = new HighScore();
    }
}
