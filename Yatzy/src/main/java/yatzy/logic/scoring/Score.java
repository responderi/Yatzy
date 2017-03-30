package yatzy.logic.scoring;

import java.util.*;
import yatzy.logic.dice.Dice;
import yatzy.logic.player.Human;
import yatzy.logic.game.*;

/**
 *
 * @author responderi
 */
public class Score {

    private int points;
    private int[] count;
    private int firstIndex;
    private int secondIndex;
    private Scanner scanner = new Scanner(System.in);

    public Score() {

    }

    public void counting(Human player, Game game) {
        points = 0;
        //First we count the amount of each number occurring.
        count = new int[7];
        count[6] = 100;
        for (int i = 0; i < 5; i++) {
            count[game.dice.get(i).getValue() - 1]++;
        }
        //Insert two highest occurring values in corresponding variables.
        firstIndex = 0;
        secondIndex = 0;
        for (int i = 0; i < 6; i++) {
            if (count[i] > count[firstIndex]) {
                secondIndex = firstIndex;
                firstIndex = i;
            } else if (count[i] > count[secondIndex]) {
                secondIndex = i;
            }
        }
        //Following statement avoid the situation where first and second index
        //could be the same. This is a plausible problem situation when two ones
        //is highest occurrance.
        if (firstIndex == secondIndex) {
            secondIndex = 6;
        }

        int input;

        //At the moment, it is expected that user does not use strings instead of integers.
        while (true) {
            if (!(player.getScore(0) != -1)) {
                System.out.println("1. Yahtzee");
            }
            if (!(player.getScore(1) != -1)) {
                System.out.println("2. Full House");
            }
            if (!(player.getScore(2) != -1)) {
                System.out.println("3. Four of a kind");
            }
            if (!(player.getScore(3) != -1)) {
                System.out.println("4. Three of a kind");
            }
            if (!(player.getScore(4) != -1)) {
                System.out.println("5. Two pairs");
            }
            if (!(player.getScore(5) != -1)) {
                System.out.println("6. A pair");
            }
            if (!(player.getScore(6) != -1)) {
                System.out.println("7. Sum");
            }
            System.out.print("Give number of the category you want to score: ");
            input = Integer.parseInt(scanner.nextLine());
            if (player.getScore(input - 1) != -1) {
                System.out.println("You have already scored this category, give new category!");
            } else {
                break;
            }
        }

        switch (input) {
            case 1:
                if (count[firstIndex] == 5) {
                    player.setScore(0, 50);
                    System.out.println("Yahtzee!!! 50 points!");
                    break;
                } else {
                    player.setScore(0, 0);
                    System.out.println("Yahtzee, 0 points.");
                    break;
                }

            case 2:
                if (count[firstIndex] == 3 && count[secondIndex] == 2) {
                    points = 3 * (firstIndex + 1) + 2 * (secondIndex + 1);
                    player.setScore(1, points);
                    System.out.println("Full House! " + points + " points!");
                    break;
                } else {
                    player.setScore(1, 0);
                    System.out.println("Full House, 0 points.");
                    break;
                }

            case 3:
                if (count[firstIndex] == 4) {
                    points = 4 * (firstIndex + 1);
                    player.setScore(2, points);
                    System.out.println("Four of a kind! " + points + " points!");
                    break;
                } else {
                    player.setScore(2, 0);
                    System.out.println("Four of a kind, 0 points.");
                    break;
                }
            case 4:
                if (count[firstIndex] == 3) {
                    points = 3 * (firstIndex + 1);
                    player.setScore(3, points);
                    System.out.println("Three of a kind! " + points + " points!");
                    break;
                } else {
                    player.setScore(3, 0);
                    System.out.println("Three of a kind, 0 points.");
                    break;
                }
            case 5:
                //CURRENTLY THERE IS A BUG INVOLVING ANOTHER PAIR BEING WITH ONES.
                System.out.println(firstIndex);
                System.out.println(secondIndex);
                if (count[firstIndex] == 2 && count[secondIndex] == 2) {
                    points = 2 * (firstIndex + 1) + 2 * (secondIndex + 1);
                    player.setScore(4, points);
                    System.out.println("Two pairs! " + points + " points!");
                    break;
                } else {
                    player.setScore(4, 0);
                    System.out.println("Two pairs, 0 points.");
                    break;
                }

            case 6:
                //CURRENTLY THERE IS A BUG INVOLVING A PAIR WITH ONES.
                if (count[firstIndex] == 2) {
                    if (count[secondIndex] == 2) {
                        System.out.println("Choose which one you want as a pair: 1. " + count[firstIndex] + " or 2. " + count[secondIndex]);
                        int pair = Integer.parseInt(scanner.nextLine());
                        if (pair == 2) {
                            points = 2 * (secondIndex + 1);
                            player.setScore(5, points);
                            System.out.println("A pair. " + points + " points.");
                            break;
                        }
                    }
                    points = 2 * (firstIndex + 1);
                    player.setScore(5, points);
                    System.out.println("A pair. " + points + " points.");
                    break;
                } else {
                    player.setScore(5, 0);
                    System.out.println("A pair, 0 points.");
                    break;
                }
            case 7:
                points = 0;
                for (int i = 0; i < 5; i++) {
                    points += game.dice.get(i).getValue();
                }
                player.setScore(6, points);
                System.out.println("Sum. " + points + " points.");
                break;

            default:
                System.out.println("Currently its expected that player puts accepted value in range. So if you see this, one category will be empty (-1).");
                break;
        }
        //Following part is for the upper section of point sheet, which is to be implented.

    }
}
