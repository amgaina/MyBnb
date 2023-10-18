
// importing files
import java.util.*;
import java.io.*;

/**
 * Class named MyBnb that is use to manage an ArrayList of RentalRoom objects
 */
public class MyBnb {

    /** Creating instance variable named rentalRooms that stores the RentalRoom objects
    */
    private List<RentalRoom> rentalRooms = new ArrayList<>();

    /**
     * Constructor named MyBnb that takes input from the file and adds the
     * information(room id and number of beds)
     * to each new RentalRoom objects.
     * 
     * @param filename the file containing information
     */
    public MyBnb(String filename) {
        try {
            File infile = new File(filename); // Creating new file object
            Scanner in = new Scanner(infile); // Creating Scanner Object for reading data from file
            while (in.hasNext()) {
                String id = in.next(); // Read the word from the file
                int no_beds = in.nextInt(); // Read the integer from the file
                rentalRooms.add(new RentalRoom(id, no_beds)); // Adding the new object to the ArrayList
            }

            in.close(); // Close Scanner
        } catch (FileNotFoundException e) { // Exception Handling
            System.out.println("File not found.");
        }
    }

    /**
     * Creating a method named numberOfRooms that returns the number of rooms having
     * the number of beds as specified in argument
     * 
     * @param num_beds the number of beds
     * @return the number of rooms having num_beds number of beds
     */
    public int numberOfRooms(int num_beds) {
        int number_rooms = 0;
        for (int i = 0; i < rentalRooms.size(); i++) {
            if ((rentalRooms.get(i).getNumBeds()) == num_beds) { // Checking if RentalRooms object has num_beds number
                                                                 // of beds
                number_rooms += 1;
            }
        }
        return number_rooms;
    }

    /**
     * Creating the method named chooseRoom that returns the ID of the room having
     * at least
     * the number of beds as specified in the argument. If no room is available,
     * then returns "NONE"
     * 
     * @param minBeds minimum number of beds
     * @return ID of the room having at least minBeds number of beds
     */
    public String chooseRoom(int minBeds) {
        for (int i = 0; i < rentalRooms.size(); i++) {
            int beds = rentalRooms.get(i).getNumBeds();
            if ((rentalRooms.get(i).isAvailable()) && beds >= minBeds) { // Checking if rentalRooms object is available
                                                                         // and at least minBeds number of beds
                rentalRooms.get(i).setAvailable(false); // Setter to set the room status to be not available for renting
                return rentalRooms.get(i).getID();
            }
        }
        return "NONE";
    }

    /**
     * Creating the method named numberOfStaffNeeded that returns the number of
     * staffs needed to clean the room that are currrently occupied.
     * 
     * @return the number of staffs needed to clean the room
     */
    public int numberOfStaffNeeded() {
        int staffs = 0; // number of staffs needed to clean the room
        int less_bedrooms = 0; // variable named less_bedrooms to store the number of bedrooms having beds less
                               // than 3

        for (int i = 0; i < rentalRooms.size(); i++) {

            int no_beds = rentalRooms.get(i).getNumBeds();

            if (!(rentalRooms.get(i).isAvailable())) { // Checking if the the room is occupied
                if (no_beds >= 3) {
                    staffs += 2;
                } 
                else {
                    if (no_beds == 2) {
                        less_bedrooms += 2;
                    } 
                    else {
                        less_bedrooms++;
                    }
                    if (less_bedrooms >= 3) {
                        staffs++;
                        less_bedrooms = less_bedrooms % 3;
                    }
                }

            }

            if (i == (rentalRooms.size() - 1)) { // Check for the last iteration
                if (less_bedrooms != 0) { // Check if there are bedrooms that does not have staff
                    staffs++;
                }
            }
        }
        return staffs;
    }

}
