import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

/**
 * Basic tests of the Taxi class.
 *
 * @author  David J. Barnes
 * @version 2017.11.08
 */
public class TaxiTest
{
    // A generator of random values.
    private Random rand;
    // The attributes of a Taxi.
    private int id;
    private int area;
    private boolean free;
    // The Taxi to be tested.
    private Taxi taxi;

    /**
     * Default constructor for test class ReadingTest
     */
    public TaxiTest()
    {
        rand = new Random();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        id = 100 + rand.nextInt(100);
        area = 1 + rand.nextInt(6);
        free = rand.nextBoolean();
        taxi = new Taxi(id, area);
        if(free) {
            taxi.setFree();
        }
        else {
            taxi.setOccupied();
        }
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
    /**
     * Test the location accessor.
     */
    public void testArea()
    {
        assertEquals(area, taxi.getArea());
    }

    @Test
    /**
     * Test the free accessor.
     */
    public void testFree()
    {
        assertEquals(free, taxi.isFree());
    }

    @Test
    /**
     * Test the day accessor.
     */
    public void testID()
    {
        assertEquals(id, taxi.getID());
    }

    @Test
    /**
     * Test the getDetails method.
     */
    public void testDetails()
    {
        assertEquals(String.format("Taxi %d is in area %d and is %sfree.",             
                             id, area, free ? "" : "not "), 
                     taxi.getDetails());
    }
}




