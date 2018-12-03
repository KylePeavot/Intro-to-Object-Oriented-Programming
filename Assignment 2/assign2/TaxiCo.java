import java.util.LinkedList;
import static java.lang.Math.abs;
/**
 * Keep track of multiple taxis.
 * @author Kyle Peavot  ksp5
 * @version 20/11/2017
 */
public class TaxiCo 
{
    private LinkedList<Taxi> taxis; //Holds instances of Taxi
    /**
     * Create a TaxiCo object.
     */
    public TaxiCo() 
    {
        taxis = new LinkedList<Taxi>(); //initialise taxis as a new linked list
    }

    /**
     * Add a new taxi.
     * @param taxi The taxi.
     */
    public void addTaxi(Taxi taxi)
    {
        taxis.add(taxi); //call the LinkedList method '.add' on taxis to add 
        //the given taxi
    }

    /**
     * Get the number of taxis.
     * @return the number of taxis.
     */
    public int getNumberOfTaxis() 
    {
        return taxis.size(); //returns the size of the linked list taxis
    }

    /*
     * Get the number of taxis in the given area.
     * @param area The area of the taxis.
     * @return the number of taxis in the given area.
     */
    public int getNumberOfTaxis(int area) 
    {
        int numOfTaxis = 0; //A counter for the amount of taxis within the given area
        for (Taxi taxi : taxis) { //for every taxi in the list taxis
            if (taxi.getArea() == area) { // check if the taxi's area is within the requested area
                numOfTaxis++; //if so, increment numOfTaxis
            }
        }
        return numOfTaxis;
    }

    /**
     * List all of the taxis, one per line.
     */
    public void list() 
    {
        for (Taxi taxi : taxis) { //for each taxi in the list taxis
            System.out.println(taxi.getDetails()); //call the method '.getDetails'
        }
    }

    /**
     * Remove the taxi with the given id.
     * @param day The id of the taxi to be removed.
     * @return true if a taxi was removed, false otherwise.
     */
    /*public boolean removeTaxi(int id) 
    {
        boolean exitFlag = false;
        int count = 0;

        while (!exitFlag) {
            if (taxis.get(count).getID() == id) { //if given id matches an id of a taxi
                taxis.remove(count); //remove the taxi
                return true;
            }

            if ((count + 1) >= taxis.size()) {
                exitFlag = true;
            } else {
                count++;
            }
        }
        return false;
    }*/
    
    public boolean removeTaxi(int id)
    {
        boolean taxiRemoved = true;
        for(Taxi taxi : taxis) {
            if(taxi.getID() == id) {
                taxis.remove(id);
                taxiRemoved = true;
            }
            else{
                taxiRemoved = false;
            }
        }
        return taxiRemoved;
    }

    /**
     * Set the status of the taxi whose ID is given.
     * @param id The taxi's ID.
     * @param area The taxi's new area.
     * @param free Whether it is now free or not.
     */
    public void setStatus(int id, int area, boolean free) 
    {
        boolean found = false; //a flag
        int count = 0; // a count
        while (!found) { //loop until the taxi is found 
            if (taxis.get(count).getID() == id) { //if this is the taxi we're looking for
                taxis.get(count).moveTo(area); //set area
                if (free) { //If free is true
                    taxis.get(count).setFree(); //set to free
                } else { // if free is not true
                    taxis.get(count).setOccupied(); //set to occupied
                }
                found = true;
            }
            if ((count + 1) > taxis.size()) { //to stop the while loop from looping infinitely
                System.out.println("Could not find taxi!");
                found = true;
            } else {
                count++;
            }
        }
    }

    /**
     * Find the nearest free taxi to the given area.
     * Distance is measured by the absolute value of the
     * difference between two areas.
     * For instance, the distance between areas 1 and 5 is 4,
     * and the distance between areas 6 and 4 is 2.
     * If more than one taxi is free and nearest to the given
     * area then the one with the lowest ID must be returned.
     * @param area Look for the taxi nearest to this area.
     * @return the nearest taxi, or null if there are no free taxis.
     */
    public Taxi findNearestFree(int area) 
    {
        int bestTaxiID = 2147483647;
        int bestTaxiArea = 2147483647;
        int bestTaxiPosition = 0;
        int position = 0;
        boolean taxiAvailable = false;
        for (Taxi taxi : taxis) { //for each taxi in taxis, check
            if (taxi.isFree()) { //if the taxi is available
                if ((abs(taxi.getArea() - area)) <= bestTaxiArea) {//if the distance between this taxi and the area a taxi was called for is less than or equal to the current best area
                    if (taxi.getID() < bestTaxiID) { //and if the taxi's id is lower than the best taxi's ID
                        //assign ID, area, and position in LinkedList to local variables. Also sets taxiAvailable to true 
                        bestTaxiID = taxi.getID();
                        bestTaxiArea = taxi.getArea();
                        bestTaxiPosition = position;
                        taxiAvailable = true;
                    }
                }
            }
            position++;
        }
        if (taxiAvailable == true) { //if an available taxi has been found
            return taxis.get(bestTaxiPosition);
        }
        return null;
    }
}
