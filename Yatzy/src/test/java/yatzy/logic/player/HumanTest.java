package yatzy.logic.player;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author responderi
 */
public class HumanTest {

    public HumanTest() {
    }

    Human testHuman;
    Human testHumanWithName;
    
    @Before
    public void setUp() {
        testHuman = new Human();
        testHumanWithName = new Human("Karpo");
    }

    @Test
    public void constructorWorksCorrectly(){
        assertEquals(testHuman.getName(), "");
        assertEquals(testHuman.isTurn(), false);
    }
    
    @Test
    public void constructorWithNameWorksCorrectly(){
        assertEquals(testHumanWithName.getName(), "Karpo");
        assertEquals(testHumanWithName.isTurn(), false);
    }
    
    @Test
    public void setNameSetsCorrectValue(){
        testHuman.setName("Pertti");
        assertEquals(testHuman.getName(), "Pertti");
    }
    
    @Test
    public void getNameReturnsCorrectValue(){
        String returnedName = testHumanWithName.getName();
        assertEquals(returnedName, "Karpo");
    }

    @Test
    public void changeTurnStateChangesStatusCorrectly(){
        testHuman.changeTurnState();
        assertEquals(testHuman.isTurn(), true);
    }
    
    @Test
    public void isTurnReturnsCorrectTurnState(){
        assertEquals(testHuman.isTurn(), false);
        testHuman.changeTurnState();
        assertEquals(testHuman.isTurn(), true);
    }
}
