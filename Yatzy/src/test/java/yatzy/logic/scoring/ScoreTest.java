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

    Game testGame;
    Score testScore;
    Human testPlayer1;
    Human testPlayer2;
    ArrayList<Dice> testDice;

    @Before
    public void setUp() {
        testPlayer1 = new Human("player1");
        testPlayer2 = new Human("player2");
        testScore = new Score();
        testDice = new ArrayList<>();
        testGame = new Game(testScore, testPlayer1, testPlayer2, testDice);

    }
    
    @Test
    public void checkScoredReturnsCorrectValue() {
        assertEquals(testScore.checkScored(0, testGame), false);
    }
    
    @Test
    public void countingScoresPair() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(4);
        testGame.dice.get(3).setValue(3);
        testGame.dice.get(4).setValue(2);
        testScore.counting(testPlayer1, testGame, 6);
        assertEquals(testPlayer1.getScore(5), 10);
    }

    @Test
    public void countingScoresSecondIndexPair() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(6);
        testGame.dice.get(3).setValue(6);
        testGame.dice.get(4).setValue(2);
        testScore.counting(testPlayer1, testGame, 6);
        assertEquals(testPlayer1.getScore(5), 12);
    }
    @Test
    public void countingScoresPairZero() {
        testGame.dice.get(0).setValue(1);
        testGame.dice.get(1).setValue(2);
        testGame.dice.get(2).setValue(3);
        testGame.dice.get(3).setValue(4);
        testGame.dice.get(4).setValue(5);
        testScore.counting(testPlayer1, testGame, 6);
        assertEquals(testPlayer1.getScore(5), 0);
    }
    
    @Test
    public void countingScoresSum() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 7);
        assertEquals(testPlayer1.getScore(6), 26);
    }
    
    @Test
    public void countingScoresTwoPairs() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(6);
        testGame.dice.get(3).setValue(6);
        testGame.dice.get(4).setValue(2);
        testScore.counting(testPlayer1, testGame, 5);
        assertEquals(testPlayer1.getScore(4), 22);
    }
    
    @Test
    public void countingScoresTwoPairsZero() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(2);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(3);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 5);
        assertEquals(testPlayer1.getScore(4), 0);
    }
    
    @Test
    public void countingScoresThrees() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(2);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 4);
        assertEquals(testPlayer1.getScore(3), 15);
    }
    
    @Test
    public void countingScoresThreesZero() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(2);
        testGame.dice.get(2).setValue(2);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 4);
        assertEquals(testPlayer1.getScore(3), 0);
    }
    
    @Test
    public void countingScoresFours() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 3);
        assertEquals(testPlayer1.getScore(2), 20);
    }
    
    @Test
    public void countingScoresFoursZero() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(6);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 3);
        assertEquals(testPlayer1.getScore(2), 0);
    }
    
    @Test
    public void countingScoresFullHouse() {
        testGame.dice.get(0).setValue(2);
        testGame.dice.get(1).setValue(2);
        testGame.dice.get(2).setValue(2);
        testGame.dice.get(3).setValue(3);
        testGame.dice.get(4).setValue(3);
        testScore.counting(testPlayer1, testGame, 2);
        assertEquals(testPlayer1.getScore(1), 12);
    }
    
    @Test
    public void countingScoresFullHouseZero() {
        testGame.dice.get(0).setValue(2);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 2);
        assertEquals(testPlayer1.getScore(1), 0);
    }
    
    @Test
    public void countingScoresYatzy() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(5);
        testScore.counting(testPlayer1, testGame, 1);
        assertEquals(testPlayer1.getScore(0), 50);
    }
    
    @Test
    public void countingScoresYatzyZero() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 1);
        assertEquals(testPlayer1.getScore(0), 0);
    }
    
    @Test
    public void countingScoresOnes() {
        testGame.dice.get(0).setValue(1);
        testGame.dice.get(1).setValue(1);
        testGame.dice.get(2).setValue(1);
        testGame.dice.get(3).setValue(1);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 8);
        assertEquals(testPlayer1.getScore(7), 4);
    }
    
    @Test
    public void countingScoresTwos() {
        testGame.dice.get(0).setValue(2);
        testGame.dice.get(1).setValue(2);
        testGame.dice.get(2).setValue(2);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 9);
        assertEquals(testPlayer1.getScore(8), 6);
    }
    
    @Test
    public void countingScoresThreesUp() {
        testGame.dice.get(0).setValue(3);
        testGame.dice.get(1).setValue(3);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 10);
        assertEquals(testPlayer1.getScore(9), 6);
    }
    
    @Test
    public void countingScoresFoursUp() {
        testGame.dice.get(0).setValue(4);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 11);
        assertEquals(testPlayer1.getScore(10), 4);
    }
    
    @Test
    public void countingScoresFives() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 12);
        assertEquals(testPlayer1.getScore(11), 20);
    }
    
    @Test
    public void countingScoresSixes() {
        testGame.dice.get(0).setValue(5);
        testGame.dice.get(1).setValue(5);
        testGame.dice.get(2).setValue(5);
        testGame.dice.get(3).setValue(5);
        testGame.dice.get(4).setValue(6);
        testScore.counting(testPlayer1, testGame, 13);
        assertEquals(testPlayer1.getScore(12), 6);
    }
}
