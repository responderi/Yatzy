package yatzy.logic.dice;

/**
 *
 * @author responderi
 */
public class Dice {

    private int value;
    private final int id;

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
