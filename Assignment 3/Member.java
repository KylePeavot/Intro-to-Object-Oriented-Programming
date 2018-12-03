
/**
 * Write a description of class Member here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Member
{
    // The person's name.
    private String name;
    // The person's membership id;
    private String membership;
    public Member(String name, String membership)
    {
        this.name = name;
        this.membership = membership;
    }

    /**
     * Return the name of this person.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the membership id of this person.
     */
    public String getMembership()
    {
        return membership;
    }
    
    public void changeMembership(String newMembership) {
        membership = newMembership;
    }
}
