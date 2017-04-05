package yatzy.logic.scoring;

/**
 *
 * @author responderi
 */
import java.util.Scanner;
import java.io.*;

public class HighScore {

    public HighScore() {

    }

    public void readHighScore() {
        Scanner scanner = null;
        File highScoreList = new File("src/highscore.txt");

        try {
            scanner = new Scanner(highScoreList);
        } catch (Exception e) {
            System.out.println("Could not read the file: " + e.getMessage());
            return;
        }

        while (scanner.hasNextLine()) {
            String row = scanner.nextLine();
            System.out.println(row);
        }

        scanner.close();
    }
    
    /**
     *
     * @param score
     */
    public void writeNewHighScore(int score) throws Exception {
        //Currently this method just adds player1's all scores.
        FileWriter addScore = new FileWriter("src/highscore.txt", true);
        addScore.write("" + score + "\n");
        addScore.close();
    }
}
