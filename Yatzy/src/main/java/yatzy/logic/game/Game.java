package yatzy.logic.game;

import java.util.*;
import yatzy.logic.dice.*;
import yatzy.logic.player.*;
import yatzy.logic.scoring.*;

/**
 *
 * @author responderi
 */
public class Game {

    private Scanner scanner = new Scanner(System.in);
    private Human player1 = new Human("player1");
    private Human player2 = new Human("player2");
    private Score score;
    public ArrayList<Dice> dice = new ArrayList<>();

    public Game(Score score) {
        this.score = score;
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

    public void printDiceValues() {
        for (int i = 0; i < 5; i++) {
            System.out.print(dice.get(i).getValue() + " ");
        }
        System.out.print("\n");
    }

    public void playGame() {
        initializeDice();
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

    }

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
}
