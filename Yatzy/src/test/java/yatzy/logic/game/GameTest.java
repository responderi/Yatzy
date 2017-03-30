package yatzy.logic.game;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.logic.scoring.*;

/**
 *
 * @author responderi
 */
public class GameTest {

    public GameTest() {
    }

    Game testGame;
    Score testScore;

    @Before
    public void setUp() {
        testScore = new Score();
        testGame = new Game(testScore);
    }

    @Test
    public void initializeDiceWorksCorrectly() {
        testGame.initializeDice();
        for (int i = 0; i < 5; i++) {
            assertEquals(testGame.dice.get(i).getValue(), 1);
        }
    }

    @Test
    public void rerollDieRollsJustOneDie() {
        testGame.initializeDice();
        for (int i = 0; i < 5; i++) {
            testGame.dice.get(i).setValue(0);
        }
        testGame.rerollDie(1);
        assertFalse(testGame.dice.get(0).getValue() == 0);
        for (int i = 1; i < 5; i++) {
            assertEquals(testGame.dice.get(i).getValue(), 0);
        }
    }
    
    @Test
    public void rerollDiceRollsEveryDice() {
        testGame.initializeDice();
        for (int i = 0; i < 5; i++) {
            testGame.dice.get(i).setValue(0);
        }
        testGame.rerollDice();
        for (int i = 0; i < 5; i++) {
            assertFalse(testGame.dice.get(i).getValue() == 0);
        }
    }

}
