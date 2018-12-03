/**
 * Model a taxi.
 * @author David J. Barnes (d.j.barnes@kent.ac.uk)
 * @version 2017.11.06
 */
public class Taxi
{
    // The taxi's ID.
    private final int id;
    // The area the taxi is currently in.
    private int area;
    // Whether the taxi is free or not.
    private boolean free;

    /**
     * Create a Taxi object.
     * @param id The taxi's ID.
     * @param area The area the taxi is currently in.

     */
    public Taxi(int id, int area)
    {
        this.id = id;
        this.area = area;
        this.free = true;
    }
    
    /**
     * Get the ID.
     * @return The ID.
     */
    public int getID()
    {
        return id;
    }

    /**
     * Get the area.
     * @return the area.
     */
    public int getArea()
    {
        return area;
    }
    
    /**
     * Return whether the taxi is free or not.
     * @return true if free, false otherwise.
     */
    public boolean isFree()
    {
        return free;
    }
    
    /**
     * Set the taxi's status to being free.
     */
    public void setFree()
    {
        free = true;
    }
    
    /**
     * Set the taxi's status to being not free.
     */
    public void setOccupied()
    {
        free = false;
    }
    
    /**
     * Move to the given area.
     */
    public void moveTo(int area)
    {
        if(area > 0) {
            this.area = area;
        }
    }

    /**
     * Get the formatted details.
     * @return the formatted details.
     */
    public String getDetails()
    {
        return String.format("Taxi %d is in area %d and is %sfree.",             
                             id, area, free ? "" : "not ");
    }    
    
    /**
     * Return the formatted details.
     * @return the formatted details.
     */
    public String toString()
    {
        return getDetails();
    }
}
