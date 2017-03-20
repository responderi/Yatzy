package yatzy.logic.dice;

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
public class DieTest {
    
    public DieTest() {
    }
    
    Die testDie;
    Die testTrueDie;
    
    @Before
    public void setUp() {
        testDie = new Die();
        testTrueDie = new Die();
        testTrueDie.activate();
    }
    
    @Test
    public void getValueWorksCorrectly(){
        assertEquals(testDie.getValue(), 1);
    }
    
    @Test
    public void getActivatedWorksCorrectly(){
        assertEquals(testDie.getActivated(), false);
    }
    
    @Test
    public void constructorWorksCorrectly(){
        assertEquals(testDie.getValue(), 1);
        assertEquals(testDie.getActivated(), false);
    }
    @Test
    public void setValueSetsCorrectValue(){
        testDie.setValue(6);
        assertEquals(testDie.getValue(), 6);
    }

    @Test
    public void activateSetsTrue(){
        testDie.activate();
        assertEquals(testDie.getActivated(), true);
    }
    @Test
    public void deactivateSetsFalse(){
        testTrueDie.deactivate();
        assertEquals(testTrueDie.getActivated(), false);
    }
}
