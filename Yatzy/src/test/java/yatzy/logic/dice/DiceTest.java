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
public class DiceTest {

    public DiceTest() {
    }

    Dice testDie;
    Dice testTrueDie;

    @Before
    public void setUp() {
        testDie = new Dice(2);
    }
    
    @Test
    public void constructorWorksCorrectly() {
        assertEquals(testDie.getId(), 2);
        assertEquals(testDie.getValue(), 1);
    }
    
    @Test
    public void getIdReturnsCorrectValue(){
        assertEquals(testDie.getId(), 2);
    }

    @Test
    public void getValueWorksCorrectly() {
        assertEquals(testDie.getValue(), 1);
    }

    @Test
    public void setValueSetsCorrectValue() {
        testDie.setValue(6);
        assertEquals(testDie.getValue(), 6);
    }

    @Test
    public void testRollRandomnessInRangeWithHugeSampleSize() {
        //Testing is impossible to be executed unambiguously due to randomness.
        for (int i = 0; i < 100001; i++) {
            testDie.roll();
            assertTrue(testDie.getValue() <= 6 && testDie.getValue() >= 1);
        }
    }
}
