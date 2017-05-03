package yatzy.logic.game;

import java.util.*;
import yatzy.gui.EndScreenGUI;
import yatzy.logic.dice.*;
import yatzy.logic.player.*;
import yatzy.logic.scoring.*;
import javax.swing.*;

/**
 *
 * @author responderi Creator of the project
 */
/**
 * This class is the game engine, which runs the game.
 */
public class Game {

    /**
     * Instances of players and the array of dice.
     */
    public Human player1;
    public Human player2;
    public Human playerInTurn;
    private Score score;
    public ArrayList<Dice> dice;
    public int rerolls;
    public int turn;

    /**
     * Constructor which sets up the game.
     *
     * @param score Connects the scoring system with the game
     * @param player1 player 1 object
     * @param player2 player 2 object
     * @param dice dice as an array
     */
    public Game(Score score, Human player1, Human player2, ArrayList<Dice> dice) {
        this.score = score;
        this.player1 = player1;
        this.player2 = player2;
        this.dice = dice;
        this.turn = 0;
        this.playerInTurn = player1;
        initializeDice();
    }

    /**
     * This method sets up the dice for the game.
     */
    public void initializeDice() {
        Dice dieFirst = new Dice(1);
        Dice dieSecond = new Dice(2);
        Dice dieThird = new Dice(3);
        Dice dieFourth = new Dice(4);
        Dice dieFifth = new Dice(5);
        dice.add(dieFirst);
        dice.add(dieSecond);
        dice.add(dieThird);
        dice.add(dieFourth);
        dice.add(dieFifth);
    }

    /**
     * This method rerolls a die given.
     * @param dieId id of a die
     */
    public void rerollDie(int dieId) {
        dice.get(dieId - 1).roll();
    }

    /**
     * This method rerolls all the dice.
     */
    public void rerollDice() {
        for (int i = 0; i < 5; i++) {
            dice.get(i).roll();
        }
    }
    
    /**
     * This method changes the player in turn.
     */
    public void changeTurn() {
        if (playerInTurn == player1) {
            playerInTurn = returnPlayerTwo();
        } else {
            playerInTurn = returnPlayerOne();
        }
    }

    /**
     * This method returns the object of player in turn.
     * @return player in turn.
     */
    public Human playerInTurn() {
        return playerInTurn;
    }

    /**
     * This method adds a turn into turn variable.
     */
    public void playTurn() {
        turn++;
    }

    /**
     * This method checks if it is last turn and in that case triggers the end game.
     */
    public void checkIfLastTurn() {
        if (turn == 26) {
            endGame();
        }
    }

    /**
     * This method triggers the end game GUI.
     */
    public void endGame() {
        EndScreenGUI endGameScreen = new EndScreenGUI(this, player1, player2, dice, score);
        SwingUtilities.invokeLater(endGameScreen);
    }

    /**
     * This method calculates the result of the game.
     * @return result of the game
     */
    public String winner() {
        if (player1.getTotalScore() > player2.getTotalScore()) {
            return player1.getName();
        } else if (player2.getTotalScore() > player1.getTotalScore()) {
            return player2.getName();
        } else {
            return "Draw!";
        }
    }

    /**
     * This method adds a roll into reroll variable.
     */
    public void addReroll() {
        rerolls++;
    }

    /**
     * This method amount of rerolls done as integer.
     * @return amount of rerolls done as integer
     */
    public int checkRerolls() {
        return rerolls;
    }
    
    /**
     * This method resets amount of rerolls done.
     */
    public void resetRerolls() {
        rerolls = 0;
    }

    /**
     * This method returns player one's object.
     * @return player1's object
     */
    public Human returnPlayerOne() {
        return player1;
    }

    /**
     * This method returns player two's object.
     * @return player2's object
     */
    public Human returnPlayerTwo() {
        return player2;
    }
}
