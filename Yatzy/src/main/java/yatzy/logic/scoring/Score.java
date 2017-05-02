package yatzy.logic.scoring;

import java.util.*;
import javax.swing.SwingUtilities;
import yatzy.gui.GameScreenGUI;
import yatzy.gui.ScoringScreenGUI;
import yatzy.logic.dice.Dice;
import yatzy.logic.player.Human;
import yatzy.logic.game.*;

/**
 * This class is responsible of counting points for given dice.
 *
 * @author responderi Creator of the project
 */
public class Score {

    private int points;
    private int[] count;
    private int firstIndex;
    private int secondIndex;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor for scores.
     *
     */
    public Score() {

    }

    public boolean checkScored(int categoryIndex, Game game) {
        return game.playerInTurn().getScore(categoryIndex) != -1;
    }

    /**
     * Following method counts the possibilites and scores for each dice
     * combination and sets the score.
     *
     * @param game Specifies the game and it dice to modify
     */
    public void counting(Human player, Game game, int index) {
        game.playTurn();
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

        switch (index) {
            case 1:
                if (count[firstIndex] == 5) {
                    player.setScore(0, 50);
                    break;
                } else {
                    player.setScore(0, 0);
                    break;
                }

            case 2:
                if (count[firstIndex] == 3 && count[secondIndex] == 2) {
                    points = 3 * (firstIndex + 1) + 2 * (secondIndex + 1);
                    player.setScore(1, points);
                    break;
                } else {
                    player.setScore(1, 0);
                    break;
                }

            case 3:
                if (count[firstIndex] == 4) {
                    points = 4 * (firstIndex + 1);
                    player.setScore(2, points);
                    break;
                } else {
                    player.setScore(2, 0);
                    break;
                }
            case 4:
                if (count[firstIndex] == 3) {
                    points = 3 * (firstIndex + 1);
                    player.setScore(3, points);
                    break;
                } else {
                    player.setScore(3, 0);
                    break;
                }
            case 5:
                //CURRENTLY THERE IS A BUG INVOLVING ANOTHER PAIR BEING WITH ONES.
                if (count[firstIndex] == 2 && count[secondIndex] == 2) {
                    points = 2 * (firstIndex + 1) + 2 * (secondIndex + 1);
                    player.setScore(4, points);
                    break;
                } else {
                    player.setScore(4, 0);
                    break;
                }

            case 6:
                //CURRENTLY THERE IS A BUG INVOLVING A PAIR WITH ONES.
                if (count[firstIndex] == 2) {
                    if ((count[secondIndex] == 2) && (count[secondIndex] > count[firstIndex])) {
                        points = 2 * (secondIndex + 1);
                        player.setScore(5, points);
                        break;
                    }
                    points = 2 * (firstIndex + 1);
                    player.setScore(5, points);
                    break;
                } else {
                    player.setScore(5, 0);
                    break;
                }
            case 7:
                points = 0;
                for (int i = 0; i < 5; i++) {
                    points += game.dice.get(i).getValue();
                }
                player.setScore(6, points);
                break;

            default:
                break;
        }
    }

}
