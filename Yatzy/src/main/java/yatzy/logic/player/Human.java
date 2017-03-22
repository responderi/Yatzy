package yatzy.logic.player;

/**
 *
 * @author responderi
 */
public class Human {

    private String name;
    private boolean turn;

    public Human() {
        this.name = "";
        this.turn = false;
    }

    public Human(String name) {
        this.name = name;
        this.turn = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isTurn() {
        return this.turn;
    }

    public void changeTurnState() {
        this.turn = !this.turn;
    }
}
