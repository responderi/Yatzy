package yatzy.logic.player;

/**
 *
 * @author responderi
 */
public interface Player {
    
    String getName(); //returns player's name
    
    String setName(); //sets new value as player's name
    
    boolean isTurn(); //returns true if its player's turn
    
    void changeTurnState();
}
