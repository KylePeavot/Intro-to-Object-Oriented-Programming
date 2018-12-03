

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BasketballPlayerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BasketballPlayerTest
{
    private BasketballPlayer basketballPl1;
    private BasketballPlayer basketballPl2;

    /**
     * Default constructor for test class BasketballPlayerTest
     */
    public BasketballPlayerTest()
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
        basketballPl1 = new BasketballPlayer("Ben Casey", "025");
        basketballPl2 = new BasketballPlayer("Clara Dent", "040");
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
        assertEquals(0, basketballPl2.getPoints());
        assertEquals(0, basketballPl1.getPoints());
    }

    @Test
    public void testIncreasePoints()
    {
        assertEquals(0, basketballPl2.getPoints());
        assertEquals(0, basketballPl1.getPoints());
        basketballPl1.increasePoints(2);
        assertEquals(2, basketballPl1.getPoints());
    }

    @Test
    public void testToString()
    {
        basketballPl2.toString();
        basketballPl1.increasePoints(2);
        basketballPl1.toString();
    }
    
    @Test
    public void testChangeMembership() {
        basketballPl1.changeMembership("002");
        assertEquals("002", basketballPl1.getMembership());
        basketballPl1.changeMembership("001");
    }
}



