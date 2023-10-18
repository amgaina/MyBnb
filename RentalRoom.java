/**
 * A class to represent the basic components of a rental room, including ID,
 * number of beds, and availability.
 * The class includes accessor methods for number of beds, ID, and availability;
 * as well as a mutator for
 * availability.
 */

public class RentalRoom {
   private int numOfBeds;
   private String propertyID;
   private boolean available;

   /**
    * Constructor to initialize the property ID and number of beds for a rental
    * room.
    * All rental rooms are initially assumed to be available
    * 
    * @param id   the property ID
    * @param beds the number of beds
    */
   public RentalRoom(String id, int beds) {
      propertyID = id;
      numOfBeds = beds;
      available = true;
   }

   /**
    * Returns the property ID corresponding to the room
    * 
    * @return the property ID
    */
   public String getID() {
      return propertyID;
   }

   /**
    * Returns the number of beds in the room
    * 
    * @return the number of beds
    */
   public int getNumBeds() {
      return numOfBeds;
   }

   /**
    * Changes the availablity status of the room
    * 
    * @param isAvailable true if available, false otherwise
    */
   public void setAvailable(boolean isAvailable) {
      available = isAvailable;
   }

   /**
    * Returns the availability status of the room
    * 
    * @return true if available, false otherwise
    */
   public boolean isAvailable() {
      return available;
   }

}