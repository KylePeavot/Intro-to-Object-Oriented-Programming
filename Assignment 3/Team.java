import java.util.*;
/**
 * Write a description of class Team here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Team
{
    // The team's name;
    private String name;
    // The team's coach.
    private Coach coach;
    // Members of the team.
    private ArrayList<Member> team;
    
    public Team(String name)
    {
        this.name = name;
        coach = null;
        team = new ArrayList<>();
    }

    /**
     * Add a player to this team.
     * @param player The player to be added.
     */
    public void addPlayer(Member player)
    {
        team.add(player);
    }

    /**
     * @return The number of players currently enrolled in this team.
     */
    public int numberOfPlayers()
    {
        return team.size();
    }

    /**
     * Return the name of this team.
     * @return The name of this team.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the coach of this team.
     * @return The coach of this team.
     */
    public Coach getCoach()
    {
        return coach;
    }

    /**
     * Set the coach for this team.
     * @param coach The class's coach.
     */
    public void setCoach(Coach coach)
    {
        this.coach = coach;
    }
    
        /**
     * Print out a team list to the terminal.
     */
    public void printTeam()
    {
        System.out.print("Coach : ");
        if (getCoach() == null) {
            System.out.println("unassigned");
        } else {
        System.out.println(coach.getName());
        }
        System.out.println("Players:");
        Iterator<Member> it = team.iterator();
        while(it.hasNext()) {
            Member player = it.next();
            System.out.println(player.toString());
        }
        System.out.println("Number of players: " + numberOfPlayers());
    }
    
    public ArrayList<Member> getTeam() {
        return team;
    }
}
