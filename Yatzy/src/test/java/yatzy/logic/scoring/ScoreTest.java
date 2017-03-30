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

/**
 *
 * @author responderi
 */
public class ScoreTest {

    public ScoreTest() {
    }

    Score testScore;
    Game testGame;

    @Before
    public void setUp() {
        testScore = new Score();
        testGame = new Game(testScore);
    }

}
