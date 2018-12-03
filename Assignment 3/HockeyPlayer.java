
/**
 * Write a description of class HockeyPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HockeyPlayer extends Player
{
    // instance variables - replace the example below with your own
    private int goals;

    /**
     * Constructor for objects of class HockeyPlayer
     */
    public HockeyPlayer(String name, String membership)
    {
        super(name, membership);
        goals = 0;
    }
    
    /**
     * return number of goals scored this season
     * @param the number of goals scored this season
     */
    public int getGoals() 
    {
        return goals;
    }
    
        /**
     * Increase the number of goals scored.
     * @param goals Additional goals scored by this player.
     */
    public void increaseGoals(int goals)
    {
        if(goals > 0) {
            this.goals += goals;
        }
        else {
            throw new RuntimeException("Invalid number of points: " + goals);
        }
    }
    
    /**
     * Print the player's name and the number of goals
     * they have scored to the output terminal.
     */
    public String toString()
    {
        return super.getName() + " (" + goals + ")";
    }
}
