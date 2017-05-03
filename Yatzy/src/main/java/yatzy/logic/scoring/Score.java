package yatzy.logic.scoring;

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

    /**
     * Constructor for scores.
     *
     */
    public Score() {

    }

    /**
     * This method checks if the category is scored already.
     * 
     * @param categoryIndex specifies the category
     * @param game specifies the game
     * @return returns true if category is scored
     */
    public boolean checkScored(int categoryIndex, Game game) {
        return game.playerInTurn().getScore(categoryIndex) != -1;
    }

    /**
     * Following method counts the possibilites and scores for each dice
     * combination and sets the score.
     *
     * @param player player in turn
     * @param game specifies the game and it dice to modify
     * @param index specifies the category
     */
    public void counting(Human player, Game game, int index) {
        game.playTurn();
        points = 0;
        //First we count the amount of each number occurring.
        count = new int[8];
        count[0] = 0;
        count[7] = 100;
        for (int i = 0; i < 5; i++) {
            count[game.dice.get(i).getValue()]++;
        }
        //Insert two highest occurring values in corresponding variables.
        firstIndex = 0;
        secondIndex = 0;
        for (int i = 1; i < 7; i++) {
            if (count[i] > count[firstIndex]) {
                secondIndex = firstIndex;
                firstIndex = i;
            } else if ((count[i] >= count[secondIndex]) && (i > secondIndex)) {
                secondIndex = i;
            }
        }
        //Following statement avoid the situation where first and second index
        //could be the same. This is a plausible problem situation when two ones
        //is highest occurrance.
        if (firstIndex == secondIndex) {
            secondIndex = 7;
        }

        switch (index) {
            case 1:
                if (count[firstIndex] == 5) {
                    player.setScore(0, 50);
                    game.checkIfLastTurn();
                    break;
                } else {
                    player.setScore(0, 0);
                    game.checkIfLastTurn();
                    break;
                }

            case 2:
                if (count[firstIndex] == 3 && count[secondIndex] == 2) {
                    points = 3 * (firstIndex) + 2 * (secondIndex);
                    player.setScore(1, points);
                    game.checkIfLastTurn();
                    break;
                } else {
                    player.setScore(1, 0);
                    game.checkIfLastTurn();
                    break;
                }

            case 3:
                if (count[firstIndex] >= 4) {
                    points = 4 * (firstIndex);
                    player.setScore(2, points);
                    game.checkIfLastTurn();
                    break;
                } else {
                    player.setScore(2, 0);
                    game.checkIfLastTurn();
                    break;
                }
            case 4:
                if (count[firstIndex] >= 3) {
                    points = 3 * (firstIndex);
                    player.setScore(3, points);
                    game.checkIfLastTurn();
                    break;
                } else {
                    player.setScore(3, 0);
                    game.checkIfLastTurn();
                    break;
                }
            case 5:
                if (count[firstIndex] == 2 && count[secondIndex] == 2) {
                    points = 2 * (firstIndex) + 2 * (secondIndex);
                    player.setScore(4, points);
                    game.checkIfLastTurn();
                    break;
                } else {
                    player.setScore(4, 0);
                    game.checkIfLastTurn();
                    break;
                }

            case 6:
                if (count[firstIndex] == 2) {
                    if ((count[secondIndex] == 2) && ((secondIndex) > (firstIndex))) {
                        points = 2 * (secondIndex);
                        player.setScore(5, points);
                        game.checkIfLastTurn();
                        break;
                    }
                    points = 2 * (firstIndex);
                    player.setScore(5, points);
                    game.checkIfLastTurn();
                    break;
                } else {
                    player.setScore(5, 0);
                    game.checkIfLastTurn();
                    break;
                }
            case 7:
                points = 0;
                for (int i = 0; i < 5; i++) {
                    points += game.dice.get(i).getValue();
                }
                player.setScore(6, points);
                game.checkIfLastTurn();
                break;
            case 8:
                points = count[1] * 1;
                player.setScore(7, points);
                game.checkIfLastTurn();
                break;

            case 9:
                points = count[2] * 2;
                player.setScore(8, points);
                game.checkIfLastTurn();
                break;

            case 10:
                points = count[3] * 3;
                player.setScore(9, points);
                game.checkIfLastTurn();
                break;

            case 11:
                points = count[4] * 4;
                player.setScore(10, points);
                game.checkIfLastTurn();
                break;

            case 12:
                points = count[5] * 5;
                player.setScore(11, points);
                game.checkIfLastTurn();
                break;

            case 13:
                points = count[6] * 6;
                player.setScore(12, points);
                game.checkIfLastTurn();
                break;

            default:
                break;
        }
    }

}
