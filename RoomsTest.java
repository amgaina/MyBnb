/**
 * Program to test the basic functionality of the MyBnb class.
 */
public class RoomsTest {
   public static void main(String[] args) {
      MyBnb rentals = new MyBnb("rental1.txt");

      System.out.printf("Number of rooms with 2 bed(s): %d\n", rentals.numberOfRooms(2)); // Expected: 3

      System.out.println(rentals.chooseRoom(3)); // Expected: AB1213

      System.out.println(rentals.numberOfStaffNeeded()); // Expected: 2

      System.out.println(rentals.chooseRoom(1)); // Expected: AB1212

      System.out.println(rentals.numberOfStaffNeeded()); // Expected: 3

      System.out.println(rentals.chooseRoom(1)); // Expected: AB233
      System.out.println(rentals.numberOfStaffNeeded()); // Expected: 3

   }
}
