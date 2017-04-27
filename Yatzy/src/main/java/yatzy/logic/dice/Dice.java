package yatzy.logic.dice;

/**
 * This class is responsible of creating and modifying of the dice.
 * 
 * @author responderi Creator of the project
 */
public class Dice {

    private int value;
    private final int id;

    /**
     * Constructor which creates a die.
     * 
     * @param id Integer that specifies a die
     */
    public Dice(int id) {
        this.value = 1;
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int getId() {
        return this.id;
    }

    /**
     * Following method rolls a die.
     */
    public void roll() {
        this.value = (int) (6.0 * Math.random()) + 1;
    }

}
