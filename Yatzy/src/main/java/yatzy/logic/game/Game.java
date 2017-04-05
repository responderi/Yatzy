package yatzy.logic.game;

import java.util.*;
import yatzy.logic.dice.*;
import yatzy.logic.player.*;
import yatzy.logic.scoring.*;

/**
 *
 * @author responderi
 */
/**
 * This class is the game engine, which runs the game.
 */
public class Game {

    /**
     * Instances of players and the array of dice.
     */
    private Scanner scanner = new Scanner(System.in);
    public Human player1 = new Human("player1");
    public Human player2 = new Human("player2");
    private Score score;
    public ArrayList<Dice> dice = new ArrayList<>();

    public Game(Score score) {
        this.score = score;
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
     * Method rerolls a die
     *
     * @see yatzy.logic.dice.Dice
     */
    public void rerollDie(int dieId) {
        dice.get(dieId - 1).roll();
    }

    /**
     * Method rerolls the dice
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

    /**
     * Following method is the game engine, which keeps track of turns.
     *
     * @see yatzy.logic.dice.Dice
     * @see yatzy.logic.player.Human
     */
    public void playGame() throws Exception {
        initializeDice();
        HighScore highScore = new HighScore();
        highScore.readHighScore();
        for (int t = 0; t < 7; t++) {
            System.out.println("Turn " + (t + 1));
            if (t == 6) {
                System.out.println("FINAL TURN!");
            }
            System.out.println("######################################");
            System.out.println("Player1 turn");
            playerAction(player1);
            System.out.println("Player1 currently has " + player1.getCurrentScore() + " points.");
            System.out.println("");
            System.out.println("Player2 turn");
            playerAction(player2);
            System.out.println("Player2 currently has " + player2.getCurrentScore() + " points.");
            System.out.println("");
        }
        System.out.println("Player1 total score: " + player1.getTotalScore());
        System.out.println("Player2 total score: " + player2.getTotalScore());
        if (player1.getTotalScore() > player2.getTotalScore()) {
            System.out.println("Player1 won!");
        } else if (player1.getTotalScore() < player2.getTotalScore()) {
            System.out.println("Player2 won!");
        } else {
            System.out.println("Draw.");
        }
        highScore.writeNewHighScore(player1.getTotalScore());

    }

    /**
     * Following method offers the actions for players to make.
     *
     * @param player Player in turn
     *
     * @see yatzy.logic.dice.Dice
     * @see yatzy.logic.player.Human
     */
    public void playerAction(Human player) {
        rerollDice();
        printDiceValues();
        int actionInput = 0;
        //At the moment, it is expected that user does not use strings instead of integers.
        while (actionInput != 1 && actionInput != 2) {
            System.out.print("What action will you do? (1. Reroll or 2. Score): ");
            actionInput = Integer.parseInt(scanner.nextLine());
            switch (actionInput) {
                case 1:
                    rerollAction();
                    System.out.println("You have one reroll left. If you dont want to use last rolls, start scoring with 0.");
                    rerollAction();
                    score.counting(player, this);
                    break;
                case 2:
                    score.counting(player, this);
                    break;
                default:
                    System.out.println("You must give integer 1 or 2! (You will be forced to score now)");
                    score.counting(player, this);
                    break;
            }
        }
    }

    /**
     * Following method offers the reroll action for players.
     *
     * @see yatzy.logic.dice.Dice
     * @see yatzy.logic.player.Human
     */
    public void rerollAction() {
        System.out.println("Give dice numbers within range 1 to 5 and end with a zero (0)");
        //It does not matter if player chooses to roll one die more then once, result wont be seen until the decision time.
        while (true) {
            int inputInteger = Integer.parseInt(scanner.nextLine());
            if (inputInteger == 0) {
                break;
            } else if (inputInteger < 1 || inputInteger > 5) {
                System.out.println("Given number must be in range of 1 to 5");
            } else {
                rerollDie(inputInteger);
            }
        }
        printDiceValues();
    }
}
