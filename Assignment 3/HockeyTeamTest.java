

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HockeyTeamTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HockeyTeamTest
{
    private HockeyPlayer hockeyPl1;
    private HockeyPlayer hockeyPl2;
    private HockeyTeam hockeyTe1;
    private Coach coach1;
    /**
     * Default constructor for test class HockeyTeamTest
     */
    public HockeyTeamTest()
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
        hockeyTe1 = new HockeyTeam("Sticks");
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
        assertEquals(0, hockeyTe1.numberOfPlayers());
    }

    @Test
    public void testOnePlayer()
    {
        assertEquals(0, hockeyTe1.numberOfPlayers());
        hockeyTe1.addPlayer(hockeyPl2);
        assertEquals(1, hockeyTe1.numberOfPlayers());
    }

    @Test
    public void testTwoPlayers()
    {
        assertEquals(0, hockeyTe1.numberOfPlayers());
        hockeyTe1.addPlayer(hockeyPl2);
        hockeyTe1.addPlayer(hockeyPl1);
        assertEquals(2, hockeyTe1.numberOfPlayers());
    }

    @Test
    public void testSetCoach()
    {
        assertNull(hockeyTe1.getCoach());
        hockeyTe1.setCoach(coach1);
        assertNotNull(hockeyTe1.getCoach());
        assertEquals(coach1, hockeyTe1.getCoach());
    }

    @Test
    public void testPrintTeam()
    {
        hockeyTe1.addPlayer(hockeyPl2);
        hockeyTe1.addPlayer(hockeyPl1);
        hockeyTe1.printTeam();
    }
}
