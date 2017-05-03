package yatzy.logic.player;

/**
 * This classs is responsible of player specific actions.
 *
 * @author responderi Creator of the project
 */
public class Human implements Player {

    private String name;
    private int[] scoreboard;

    /**
     * Creates an instance of a player without a name.
     */
    public Human() {
        this.name = "";
        this.scoreboard = new int[14];
        initializeScoreboard();
    }

    /**
     * Creates an instance of a player.
     *
     * @param name Pre-setup name
     */
    public Human(String name) {
        this.name = name;
        this.scoreboard = new int[14];
        initializeScoreboard();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Following method initializes player specific scoreboard.
     */
    public final void initializeScoreboard() {
        for (int i = 0; i < 14; i++) {
            this.scoreboard[i] = -1;
        }
    }

    /**
     * Returns certain category's points.
     *
     * @param category Specifies the scored category
     * @param score Specifies the points to be scored
     */
    public void setScore(int category, int score) {
        this.scoreboard[category] = score;
    }

    /**
     * Returns certain category's points.
     *
     * @param category Specifies the scored category
     * @return returns integer value of points
     */
    public int getScore(int category) {
        return this.scoreboard[category];
    }

    /**
     * Following method returns player's total score.
     *
     * @return total score
     *
     */
    public int getTotalScore() {
        int sum = 0;
        for (int i = 0; i < 14; i++) {
            if (this.scoreboard[i] != -1) {
                sum += this.scoreboard[i];
            }
        }
        return sum;
    }

    /**
     * Following method returns player's current score.
     *
     * @return current score
     */
    public int getCurrentScore() {
        int sum = 0;
        for (int i = 0; i < 14; i++) {
            if (this.scoreboard[i] != -1) {
                sum += this.scoreboard[i];
            }
        }
        return sum;
    }

    /**
     * This method returns score of the upper section.
     * @return sum of points
     */
    public int getUpperSectionScore() {
        int sum = 0;
        for (int i = 7; i < 14; i++) {
            if (this.scoreboard[i] != -1) {
                sum += this.scoreboard[i];
            }
        }
        if (sum >= 63) {
            sum += 50;
        }
        return sum;
    }

    /**
     * This method returns the amount of bonus points if there are any for the player.
     * @return bonus points
     */
    public int upperSectionBonus() {
        if (this.getUpperSectionScore() >= 63) {
            return 50;
        } else {
            return 0;
        }
    }
}
