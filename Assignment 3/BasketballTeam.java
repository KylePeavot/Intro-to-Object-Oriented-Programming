import java.util.*;

/**
 * The BasketballTeam class represents details of the 
 * members of a basketball team.
 * It stores details the coach and members of the team.
 * 
 * @author David Barnes
 * @version 2017.12.06
 */
public class BasketballTeam extends Team
{

    /**
     * Create a BasketballTeam with no coach or members.
     * @param name The name of the team.
     */
    public BasketballTeam(String name)
    {
        super(name);
    }

    /**
     * Print out a team list to the terminal.
     */
    public void printTeam()
    {
        System.out.println("Basketball Team");
        super.printTeam();
    }
}
