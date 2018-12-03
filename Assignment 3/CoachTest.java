

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CoachTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CoachTest
{
    private Coach coach1;

    /**
     * Default constructor for test class CoachTest
     */
    public CoachTest()
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
    public void testGetName()
    {
        assertEquals("Amy Blunt", coach1.getName());
    }

    @Test
    public void testMembership()
    {
        assertEquals("001", coach1.getMembership());
    }

    @Test
    public void testQualifications()
    {
        assertEquals("MNHA", coach1.getQualifications());
    }
    
    @Test
    public void testChangeMembership() {
        coach1.changeMembership("002");
        assertEquals("002", coach1.getMembership());
        coach1.changeMembership("001");
    }
}



