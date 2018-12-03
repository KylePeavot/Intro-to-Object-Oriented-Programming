import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

/**
 * The test class TaxiCoTest.
 *
 * @author David J. Barnes (d.j.barnes@kent.ac.uk)
 * @version 2016.11.02
 */
public class TaxiCoTest
{
    // The company to be tested.
    private TaxiCo company;
    // A generator of random values.
    private Random rand;
    // Shadow copy of the taxis.
    private Vector<Taxi> shadow;
    private int numTaxis;
    // The number of areas.
    private int numAreas;
    // The chosen area for testing.
    private int chosenArea;
    // The number of taxis in the chosen area.
    private int numberInChosenArea;
    
    /**
     * Constructor for test class TaxiCoTest
     */
    public TaxiCoTest()
    {
        rand = new Random();
        // The remaining fields will be initialised properly
        // in the setup method before each test.
        company = null;
        shadow = new Vector<>();
    }

    /**
     * Sets up the test fixture.
     * Generates random values for the taxis.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        company = new TaxiCo();
        numAreas = 4 + rand.nextInt(5);
        numTaxis = numAreas * 5;
        chosenArea = 1 + rand.nextInt(numAreas);
        numberInChosenArea = 0;
        for(int t = 1; t <= numTaxis; t++) { 
            int area = 1 + rand.nextInt(numAreas);
            shadow.add(makeTaxi(100 + t, area, rand.nextBoolean()));
            if(area == chosenArea) {
                numberInChosenArea++;
            }
        }
        while(numberInChosenArea < 2) {
            // Ensure sufficient, for testing purposes.
            numTaxis++;
            boolean free = rand.nextBoolean();
            shadow.add(makeTaxi(100 + numTaxis, chosenArea, free));
            numberInChosenArea++;
       }

    }
    
    /**
     * Make a new taxi.
     */
    private Taxi makeTaxi(int id, int area, boolean free)
    {
        Taxi taxi = new Taxi(id, area);
        if(free) {
            taxi.setFree();
        }
        else {
            taxi.setOccupied();
        }
        company.addTaxi(taxi);
        return taxi;
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        shadow.clear();
    }

    @Test
    /**
     * Test that the number of taxis in the company is correct.
     */
    public void size()
    {
        assertEquals(numTaxis, company.getNumberOfTaxis());
    }

    @Test
    /**
     * Test that there are no taxis for an invalid location.
     */
    public void sizeArea0()
    {
        assertEquals(0, company.getNumberOfTaxis(0));
    }

    @Test
    /**
     * Test the number of taxis for location 1.
     */
    public void sizeChosenArea()
    {
        assertEquals(numberInChosenArea, company.getNumberOfTaxis(chosenArea));
    }
    
    @Test
    /**
     * Test the list method.
     */
    public void list()
    {
        company = new TaxiCo();
        makeTaxi(1, 2, false);
        makeTaxi(5, 1, true);
        company.list();
    }

    @Test
    /**
     * Test that removing of taxis for an invalid id
     * works ok.
     */
    public void remove0()
    {
        assertEquals(numTaxis, company.getNumberOfTaxis());
        assert(!company.removeTaxi(rand.nextInt(100)));
        assertEquals(numTaxis, company.getNumberOfTaxis());
    }

    @Test
    /**
     * Test removal of taxis from the chosen area.
     */
    public void removeTaxi()
    {
        // Select a random Taxi to be removed.
        Taxi selected = shadow.get(rand.nextInt(shadow.size()));
        assert(company.removeTaxi(selected.getID()));
        // Make sure it cannot be removed twice.
        assert(!company.removeTaxi(selected.getID()));
    }
    
    @Test
    /**
     * Test movement of a taxi to another area.
     */
    public void moveTaxi()
    {
        // Select a random Taxi to be moved.
        Taxi selected = shadow.get(rand.nextInt(shadow.size()));
        int oldArea = selected.getArea();
        boolean oldStatus = selected.isFree();
        company.setStatus(selected.getID(), oldArea + 1, !oldStatus);
        assertEquals(selected.getArea(), oldArea + 1);
        assertEquals(selected.isFree(), !oldStatus);
    }
    
    @Test
    /**
     * Find the nearest taxi when there are none.
     */
    public void findNoTaxis()
    {
        shadow.clear();
        company = new TaxiCo();
        Taxi taxi = company.findNearestFree(1);
        assertEquals(taxi, null);
    }
    
    @Test
    /**
     * Find the nearest taxi when there are none free.
     */
    public void findTaxiNoneFree()
    {
        shadow.clear();
        company = new TaxiCo();
        makeTaxi(1, 1, false);
        assertEquals(company.findNearestFree(1), null);
    }

    
    @Test
    /**
     * Find the nearest taxi when there is one free.
     */
    public void findTaxiOneFree()
    {
        shadow.clear();
        company = new TaxiCo();
        makeTaxi(1, 1, false);
        Taxi taxi = makeTaxi(2, 1, true);
        assertEquals(company.findNearestFree(1), taxi);
    }

    
    @Test
    /**
     * Find the nearest taxi when there is more than one free.
     */
    public void findTaxiLowest()
    {
        shadow.clear();
        company = new TaxiCo();
        Taxi taxi = makeTaxi(1, 1, true);
        makeTaxi(2, 1, true);
        assertEquals(company.findNearestFree(1), taxi);
    }
    
    @Test
    /**
     * Find the nearest taxi when there are none.
     */
    public void findTaxiLowestMultiple()
    {
        shadow.clear();
        company = new TaxiCo();
        for(int id = 5; id >= 2; id--) {
            makeTaxi(id, 1, true);
        }
        Taxi taxi = makeTaxi(1, 1, true);
        assertEquals(company.findNearestFree(1), taxi);
    }
    
    @Test
    /**
     * Find the nearest taxi in neighbouring areas.
     */
    public void findTaxiNeighbours()
    {
        shadow.clear();
        company = new TaxiCo();
        Taxi taxi = makeTaxi(1, 1, true);
        makeTaxi(2, 3, true);
        assertEquals(company.findNearestFree(2), taxi);
    }
    
    @Test
    /**
     * Find the nearest taxi in neighbouring areas
     * when only one is free.
     */
    public void findTaxiNeighboursOneFree()
    {
        shadow.clear();
        company = new TaxiCo();
        makeTaxi(1, 1, false);
        Taxi taxi = makeTaxi(2, 3, true);
        assertEquals(company.findNearestFree(2), taxi);
    }
    
    @Test
    /**
     * Find the nearest taxi in neighbouring areas.
     */
    public void findTaxiNeighboursFurther()
    {
        shadow.clear();
        company = new TaxiCo();
        makeTaxi(1, 2, false);
        Taxi taxi = makeTaxi(5, 1, true);
        assertEquals(company.findNearestFree(3), taxi);
    }
    
    @Test
    /**
     * Find the nearest taxi in neighbouring areas.
     */
    public void findTaxiMultipleNeighbours()
    {
        Collections.shuffle(shadow);
        Taxi taxi = shadow.get(0);
        taxi.setFree();
        for(int i = 1; i < shadow.size(); i++) {
            shadow.get(i).setOccupied();
        }
        assertEquals(company.findNearestFree(taxi.getArea()), taxi);
    }
}




