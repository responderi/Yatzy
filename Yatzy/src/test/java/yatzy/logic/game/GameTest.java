package yatzy.logic.game;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.logic.dice.Dice;
import yatzy.logic.player.Human;
import yatzy.logic.scoring.*;

/**
 *
 * @author responderi
 */
public class GameTest {

    public GameTest() {
    }

    Game testGame;
    Game testGameForPlayers;
    Score testScore;
    Human testPlayer1;
    Human testPlayer2;
    Human player1;
    Human player2;
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
    public void constructorAndInitializeDiceWorksCorrectly() {
        for (int i = 0; i < 5; i++) {
            assertEquals(testGame.dice.get(i).getValue(), 1);
        }
    }

    @Test
    public void rerollDieRollsJustOneDie() {
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
        for (int i = 0; i < 5; i++) {
            testGame.dice.get(i).setValue(0);
        }
        testGame.rerollDice();
        for (int i = 0; i < 5; i++) {
            assertFalse(testGame.dice.get(i).getValue() == 0);
        }
    }
    
    @Test
    public void changeTurnSwitchesActivePlayer() {
        testGame.changeTurn();
        assertEquals(testGame.playerInTurn(), testPlayer2);
    }
    
    @Test
    public void changeTurnSwitchesActivePlayerAlternative() {
        testGame.playerInTurn = testPlayer2;
        testGame.changeTurn();
        assertEquals(testGame.playerInTurn(), testPlayer1);
    }
    
    @Test
    public void playTurnAddsTurnCorrectly() {
        testGame.playTurn();
        assertEquals(testGame.turn, 1);
    }
    
    @Test
    public void winnerGivesDrawWhenEvenPoints() {
        assertEquals(testGame.winner(), "Draw!");
    }
    
    @Test
    public void winnerGivesPlayer1AsWinner() {
        testPlayer1.setScore(0, 50);
        assertEquals(testGame.winner(), testPlayer1.getName());
    }
    
    @Test
    public void winnerGivesPlayer2AsWinner() {
        testPlayer2.setScore(0, 50);
        assertEquals(testGame.winner(), testPlayer2.getName());
    }
    
    @Test
    public void addRerollAddsRollCorrectly() {
        testGame.addReroll();
        testGame.addReroll();
        assertEquals(testGame.rerolls, 2);
    }
    
    @Test
    public void resetRerollsSetsZeroAsValue() {
        testGame.addReroll();
        testGame.addReroll();
        testGame.addReroll();
        testGame.resetRerolls();
        assertEquals(testGame.rerolls, 0);
    }
    
    @Test
    public void checkRerollsReturnsCorrectValue() {
        testGame.addReroll();
        testGame.addReroll();
        testGame.addReroll();
        testGame.addReroll();
        assertEquals(testGame.checkRerolls(), 4);
    }
    
    @Test
    public void returnPlayerOneReturnsCorrectPlayer() {
        assertEquals(testGame.returnPlayerOne(), testPlayer1);
    }
    
    @Test
    public void returnPlayerTwoReturnsCorrectPlayer() {
        assertEquals(testGame.returnPlayerTwo(), testPlayer2);
    }
}
