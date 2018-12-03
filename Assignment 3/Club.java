import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Store details of the membership of a Club
 * 
 * @author David J. Barnes
 * @version 2017.12.06
 */
public class Club
{
    // The name of the club.
    private String title;
    // The members of the club.
    private List<Member> members;

    /**
     * Constructor for objects of class Club.
     * @param The club's title.
     */
    public Club(String title)
    {
        this.title = title;
        members = new ArrayList<>();
    }
   
    /**
     * Add a member to the membership list
     * @param member The member to be added
     */
    public void addMember(Member member) 
    {
        members.add(member);
    }
    
    /**
     * List the membership of the club.
     */
    public void printMembership()
    {
        System.out.println("Membership of the " + title + " Club");
        Iterator it = members.iterator();
        while(it.hasNext()) {
            Object member = it.next();
            System.out.println(member);
        }
    }
}

