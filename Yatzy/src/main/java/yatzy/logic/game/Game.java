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
    private Scanner scanner = new Scanner(System.in);
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

    /**
     * Method initializes the dice.
     *
     * @see yatzy.logic.dice.Dice
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
     * Method rerolls a die.
     *
     * @param dieId Die to be rolled
     *
     * @see yatzy.logic.dice.Dice
     */
    public void rerollDie(int dieId) {
        dice.get(dieId - 1).roll();
    }

    /**
     * Method rerolls the dice.
     *
     * @see yatzy.logic.dice.Dice
     */
    public void rerollDice() {
        for (int i = 0; i < 5; i++) {
            dice.get(i).roll();
        }
    }

    /**
     * Method prints dice values.
     *
     * @see yatzy.logic.dice.Dice
     */
    public void printDiceValues() {
        for (int i = 0; i < 5; i++) {
            System.out.print(dice.get(i).getValue() + " ");
        }
        System.out.print("\n");
    }

    public void printHighScore() {
        HighScore highScore = new HighScore();
        highScore.readHighScore();
    }

    public void setNewHighScore(HighScore highScore) throws Exception {
        highScore.writeNewHighScore(player1.getTotalScore());
    }

    public void changeTurn() {
        if (playerInTurn == player1) {
            playerInTurn = player2;
        } else {
            playerInTurn = player1;
        }
    }

    public Human playerInTurn() {
        return playerInTurn;
    }

    /**
     * Following method is the game engine, which keeps track of turns.
     *
     * @throws java.lang.Exception Throws exception if cant find file for
     * highscore.
     * @see yatzy.logic.dice.Dice
     * @see yatzy.logic.player.Human
     */
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
