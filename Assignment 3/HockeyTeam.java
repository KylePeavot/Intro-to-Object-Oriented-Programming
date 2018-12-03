
/**
 * Write a description of class HockeyTeam here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HockeyTeam extends Team
{
    /**
     * Create a HockeyTeam with no coach or members.
     * @param name The name of the team.
     */
    public HockeyTeam(String name)
    {
        super(name);
    }

     /**
     * Print out a team list to the terminal.
     */
    public void printTeam() 
    {
       System.out.println("Hockey Team");
       super.printTeam();
    }
}
