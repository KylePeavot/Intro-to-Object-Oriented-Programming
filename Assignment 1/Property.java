
/**
 * A small program that simulates a house auctioning experience
 *
 * @author Kyle Peavot
 * @version 09/10/2017
 */
public class Property
{
    private int reservePrice;
    private int highestOffer;
    private String propertyAddress;
    
    public Property(int price, String address) {
        /*
         * constructor for Property
         * sets reserve price at users input or 50000 - whichever
         * is greater
         */
        if (price < 50000) {
            reservePrice = 50000;
        } else {
        reservePrice = price;
        }
        highestOffer = 0;
        propertyAddress = address;
    }
    
    public String GetPropertyAddress() {
        /*
         * Accessor method for address
         */
        return propertyAddress;
    }

    public int GetHighestOffer() {
        /*
         * Accessor method for highest offer
         */
        return highestOffer;
    }
    
    public void SetPropertyAddress(String address) {
        /*
         * sets propertyAddress as new input into this method
         */
        propertyAddress = address;
    }
    
    public void makeOffer(int newOffer) {
        /*
         * Take a new offer and decide whether it is accepted based
         * on whether it is higher than the current highest offer
         */
        if (newOffer > highestOffer) {
            highestOffer = newOffer;
        } else {
            System.out.println("ERROR: The offer was not accepted");
            System.out.println("Your offer was " + newOffer);
            System.out.println("The current highest offer is " + highestOffer);
        }
    }
    
    public void changeReserve(int newReserve) {
        /*
         * Setter/mutator method for reserve price
         * Checks if the newReserve is greater than 50000
         * if it is, newReserve is now the reservePrice
         */
        if (newReserve >= 50000) {
            reservePrice = newReserve;
        }
    }
    
    public void printDetails() {
        /*
         * Tells user what the highest offer is and if it meets the reserveOffer
         */
        if (highestOffer >= reservePrice) {
            System.out.println("The current offer for "
                + propertyAddress + " is " + highestOffer + ".");
        } else {
            System.out.println("The current offer for "
                + propertyAddress + " is " + highestOffer + ".");
            System.out.println("The reserve has not been met.");
        }
    }
}
