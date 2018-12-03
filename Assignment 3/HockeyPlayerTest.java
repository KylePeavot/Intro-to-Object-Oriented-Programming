

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HockeyPlayerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HockeyPlayerTest
{
    private HockeyPlayer hockeyPl1;
    private HockeyPlayer hockeyPl2;
    /**
     * Default constructor for test class HockeyPlayerTest
     */
    public HockeyPlayerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        hockeyPl1 = new HockeyPlayer("Ben Casey", "025");
        hockeyPl2 = new HockeyPlayer("Clara Dent", "040");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testZeroPoints()
    {
        assertEquals(0, hockeyPl2.getGoals());
        assertEquals(0, hockeyPl1.getGoals());
    }

    @Test
    public void testIncreasePoints()
    {
        assertEquals(0, hockeyPl2.getGoals());
        assertEquals(0, hockeyPl1.getGoals());
        hockeyPl1.increaseGoals(2);
        assertEquals(2, hockeyPl1.getGoals());
    }

    @Test
    public void testToString()
    {
        hockeyPl2.toString();
        hockeyPl1.increaseGoals(2);
        hockeyPl1.toString();
    }
    
    @Test
    public void testChangeMembership() {
        hockeyPl1.changeMembership("002");
        assertEquals("002", hockeyPl1.getMembership());
        hockeyPl1.changeMembership("001");
    }
}

