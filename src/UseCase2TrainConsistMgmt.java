/**
 * ================================================
 * MAIN CLASS - UseCase2TrainConsistMgmt
 * ================================================
 *
 * Use Case 2: Add Passenger Bogies to Train
 *
 * Description:
 * This class demonstrates how passenger bogies can be
 * managed dynamically using ArrayList operations.
 *
 * At this stage, the application:
 * - Adds new bogies to the train
 * - Removes existing bogies
 * - Checks for bogie availability
 * - Displays the final consist
 *
 * This maps CRUD operations using ArrayList.
 *
 * @author Developer
 * @version 2.0
 */

import java.util.ArrayList;
import java.util.List;

public class UseCase2TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("=======================================\n");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // ---- CREATE (Add bogies) ----
        // add() attaches a new bogie to the train
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        passengerBogies.add("Sleeper");

        System.out.println("Bogies after addition: " + passengerBogies);
        System.out.println("Total Bogies: " + passengerBogies.size());

        // ---- DELETE (Remove a bogie) ----
        // remove() detaches a bogie from the train
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing AC Chair: " + passengerBogies);

        // ---- READ (Check existence) ----
        // contains() checks if a specific bogie exists
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("\nDoes Sleeper exist? " + hasSleeper);

        System.out.println("\nFinal Train Consist: " + passengerBogies);
        System.out.println("Final Bogie Count: " + passengerBogies.size());
    }
}
