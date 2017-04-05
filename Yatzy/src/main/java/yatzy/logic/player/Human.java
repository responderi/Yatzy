package yatzy.logic.player;

/**
 *
 * @author responderi
 */
public class Human implements Player {

    private String name;
    private int[] scoreboard;

    public Human() {
        this.name = "";
        this.scoreboard = new int[8];
        initializeScoreboard();
    }

    public Human(String name) {
        this.name = name;
        this.scoreboard = new int[8];
        initializeScoreboard();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public final void initializeScoreboard() {
        for (int i = 0; i < 8; i++) {
            this.scoreboard[i] = -1;
        }
    }

    public void setScore(int category, int score) {
        this.scoreboard[category] = score;
    }

    public int getScore(int category) {
        return this.scoreboard[category];
    }

    public int getTotalScore() {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            if (this.scoreboard[i] != -1) {
                sum += this.scoreboard[i];
            }
        }
        return sum;
    }

    public int getCurrentScore() {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            if (this.scoreboard[i] != -1) {
                sum += this.scoreboard[i];
            }
        }
        return sum;
    }
}
