/**
 * A class storing details of a coach.
 * 
 * @author David J. Barnes
 * @version 2017.12.06
 */
public class Coach extends Member 
{
    // The coach's qualifications.
    private String qualifications;

    /**
     * Setup the coach's details.
     * @param name The coach's name.
     * @param name The coach's membership id.
     * @param name The coach's qualifications.
     */
    public Coach(String name, String membership, String qualifications)
    {
        super(name, membership);
        this.qualifications = qualifications;
        
    }
    
    /**
     * Return the qualifications of this coach.
     */
    public String getQualifications()
    {
        return qualifications;
    }
    
    /**
     * Return full details of this coach.
     * @return Full detais of this coach.
     */
    public String toString()
    {
        // Build up a string representing this
        // coach's information.
        StringBuilder details = new StringBuilder();
        details.append(super.getName());
        details.append(' ');
        // Only include the qualifications if there
        // are any.
        if(qualifications != null && qualifications.trim().length() > 0) {
            details.append("(" + qualifications + ")");
            details.append(' ');
        }
        details.append(super.getMembership());
        return details.toString();
    }
}
