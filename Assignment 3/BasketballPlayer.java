/**
 * The BasketballPlayer class represents a player in a basketball team.
 * 
 * @author David Barnes
 * @version 2017.12.06
 */
public class BasketballPlayer extends Player
{
    // The number of points scored this season.
    private int points;

    /**
     * Create a new basketball player with the given details.
     * @param name The name of this player.
     * @param membership The player's membership id.
     */
    public BasketballPlayer(String name, String membership)
    {
        super(name, membership);
        points = 0;
    }
    /**
     * Return the number of points scored this season.
     * @return The number of points scored this season.
     */
    public int getPoints()
    {
        return points;
    }

    /**
     * Increase the number of points scored.
     * @param points Additional points scored by this player.
     */
    public void increasePoints(int points)
    {
        if(points > 0) {
            this.points += points;
        }
        else {
            throw new RuntimeException("Invalid number of points: " + points);
        }
    }

    /**
     * Print the player's name and the number of points
     * they have scored to the output terminal.
     */
    public String toString()
    {
        return super.getName() + " (" + points + ")";
    }
}
