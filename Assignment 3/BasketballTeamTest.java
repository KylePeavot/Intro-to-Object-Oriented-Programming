

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BasketballTeamTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BasketballTeamTest
{
        private BasketballPlayer basketballPl1;
        private BasketballPlayer basketballPl2;
        private BasketballTeam basketballTe1;
        private Coach coach1;

    /**
     * Default constructor for test class BasketballTeamTest
     */
    public BasketballTeamTest()
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
        basketballTe1 = new BasketballTeam("Sticks");
        coach1 = new Coach("Amy Blunt", "001", "MNHA");
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
    public void testNoTeam()
    {
        assertEquals(0, basketballTe1.numberOfPlayers());
    }

    @Test
    public void testOnePlayer()
    {
        assertEquals(0, basketballTe1.numberOfPlayers());
        basketballTe1.addPlayer(basketballPl2);
        assertEquals(1, basketballTe1.numberOfPlayers());
    }

    @Test
    public void testTwoPlayers()
    {
        assertEquals(0, basketballTe1.numberOfPlayers());
        basketballTe1.addPlayer(basketballPl2);
        basketballTe1.addPlayer(basketballPl1);
        assertEquals(2, basketballTe1.numberOfPlayers());
    }

    @Test
    public void testSetCoach()
    {
        assertNull(basketballTe1.getCoach());
        basketballTe1.setCoach(coach1);
        assertNotNull(basketballTe1.getCoach());
        assertEquals(coach1, basketballTe1.getCoach());
    }

    @Test
    public void testPrintTeam()
    {
        basketballTe1.addPlayer(basketballPl2);
        basketballTe1.addPlayer(basketballPl1);
        basketballTe1.printTeam();
    }
}





