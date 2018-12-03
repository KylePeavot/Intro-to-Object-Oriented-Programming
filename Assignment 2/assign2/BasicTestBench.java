

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BasicTestBench.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BasicTestBench
{
    private TaxiCo taxiCo1;
    private Taxi taxi1;
    private Taxi taxi2;
    private Taxi taxi3;
    private Taxi taxi4;

    /**
     * Default constructor for test class BasicTestBench
     */
    public BasicTestBench()
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
        taxiCo1 = new TaxiCo();
        taxi1 = new Taxi(1, 1);
        taxi2 = new Taxi(2, 2);
        taxi3 = new Taxi(3, 2);
        taxi4 = new Taxi(4, 3);
        taxiCo1.addTaxi(taxi1);
        taxiCo1.addTaxi(taxi2);
        taxiCo1.addTaxi(taxi3);
        taxiCo1.addTaxi(taxi4);
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
}
