package yatzy.logic.dice;

/**
 *
 * @author responderi
 */
public class Die {
    
    private int value;
    private boolean activated;
    
    public Die() {
        this.value = 1;
        this.activated = false;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void activate() {
        this.activated = true;
    }
    
    public void deactivate() {
        this.activated = false;
    }
    
    public boolean getActivated() {
        return this.activated;
    }
}
