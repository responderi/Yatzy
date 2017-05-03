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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        testHuman = new Human();
        testHumanWithName = new Human("Karpo");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void constructorWorksCorrectly() {
        assertEquals(testHuman.getName(), "");
        for (int i = 0; i < 7; i++) {
            assertEquals(testHuman.getScore(i), -1);
        }
    }

    @Test
    public void constructorWithNameWorksCorrectly() {
        assertEquals(testHumanWithName.getName(), "Karpo");
        for (int i = 0; i < 7; i++) {
            assertEquals(testHumanWithName.getScore(i), -1);
        }
    }

    @Test
    public void setNameSetsCorrectValue() {
        testHuman.setName("Pertti");
        assertEquals(testHuman.getName(), "Pertti");
    }

    @Test
    public void getNameReturnsCorrectValue() {
        String returnedName = testHumanWithName.getName();
        assertEquals(returnedName, "Karpo");
    }

    @Test
    public void initializeScoreboardSetsUpTheArrayCorrectly() {
        testHuman.initializeScoreboard();
        for (int i = 0; i < 7; i++) {
            assertEquals(testHuman.getScore(i), -1);
        }
    }

    @Test
    public void getCurrentScoreReturnsCorrectSum() {
        testHuman.setScore(6, 5);
        assertEquals(testHuman.getCurrentScore(), 5);
    }

    @Test
    public void getTotalScoreReturnsCorrectSum() {
        testHuman.setScore(0, 50);
        testHuman.setScore(1, 19);
        testHuman.setScore(2, 12);
        testHuman.setScore(3, 9);
        testHuman.setScore(4, 12);
        testHuman.setScore(5, 6);
        testHuman.setScore(6, 20);
        assertEquals(testHuman.getTotalScore(), 128);
    }
    
    @Test
    public void getUpperSectionScoreWithBonus() {
        testHuman.setScore(7, 6);
        testHuman.setScore(8, 6);
        testHuman.setScore(9, 9);
        testHuman.setScore(10, 12);
        testHuman.setScore(11, 15);
        testHuman.setScore(12, 18);
        assertEquals(testHuman.getUpperSectionScore(), 116);
    }
    
    @Test
    public void getUpperSectionScoreWithoutBonus() {
        testHuman.setScore(7, 6);
        testHuman.setScore(8, 6);
        testHuman.setScore(9, 9);
        testHuman.setScore(10, 12);
        testHuman.setScore(11, 15);
        testHuman.setScore(12, 12);
        assertEquals(testHuman.getUpperSectionScore(), 60);
    }
    
    @Test
    public void upperSectionScoreWithBonus() {
        testHuman.setScore(7, 6);
        testHuman.setScore(8, 6);
        testHuman.setScore(9, 9);
        testHuman.setScore(10, 12);
        testHuman.setScore(11, 15);
        testHuman.setScore(12, 18);
        assertEquals(testHuman.upperSectionBonus(), 50);
    }
    
    @Test
    public void upperSectionScoreWithoutBonus() {
        testHuman.setScore(7, 6);
        testHuman.setScore(8, 6);
        testHuman.setScore(9, 9);
        testHuman.setScore(10, 12);
        testHuman.setScore(11, 15);
        testHuman.setScore(12, 12);
        assertEquals(testHuman.upperSectionBonus(), 0);
    }

}
