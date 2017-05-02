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
     * @param player1
     * @param player2
     * @param dice
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

    public void rerollDie(int dieId) {
        dice.get(dieId - 1).roll();
    }

    public void rerollDice() {
        for (int i = 0; i < 5; i++) {
            dice.get(i).roll();
        }
    }
    
    public void changeTurn() {
        if (playerInTurn == player1) {
            playerInTurn = returnPlayerTwo();
        } else {
            playerInTurn = returnPlayerOne();
        }
    }

    public Human playerInTurn() {
        return playerInTurn;
    }

    public void playTurn() {
        turn++;
    }

    public void checkIfLastTurn() {
        if (turn == 14) {
            endGame();
        }
    }

    public void endGame() {
        EndScreenGUI endGameScreen = new EndScreenGUI(this, player1, player2, dice, score);
        SwingUtilities.invokeLater(endGameScreen);
    }

    public String winner() {
        if (player1.getTotalScore() > player2.getTotalScore()) {
            return player1.getName();
        } else if (player2.getTotalScore() > player1.getTotalScore()) {
            return player2.getName();
        } else {
            return "Draw!";
        }
    }

    public void addReroll() {
        rerolls++;
    }

    public int checkRerolls() {
        return rerolls;
    }

    public void resetRerolls() {
        rerolls = 0;
    }

    public Human returnPlayerOne() {
        return player1;
    }

    public Human returnPlayerTwo() {
        return player2;
    }
}
