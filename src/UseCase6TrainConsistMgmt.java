/**
 * ================================================
 * MAIN CLASS - UseCase6TrainConsistMgmt
 * ================================================
 *
 * Use Case 6: Map Bogie to Capacity (HashMap)
 *
 * Description:
 * This class uses HashMap to associate each bogie with its
 * seating or load capacity using key-value mapping.
 *
 * At this stage, the application:
 * - Creates a HashMap<String, Integer> for bogie-capacity mapping
 * - Adds entries using put()
 * - Iterates using entrySet()
 * - Displays each bogie with its capacity
 *
 * @author Developer
 * @version 6.0
 */

import java.util.HashMap;
import java.util.Map;

public class UseCase6TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC6 - Map Bogie to Capacity ");
        System.out.println("=======================================\n");

        // Create a HashMap to map bogie names to capacities
        Map<String, Integer> bogieCapacity = new HashMap<>();

        // ---- ADD bogie-capacity mappings ----
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Goods", 0);

        System.out.println("Bogie Capacity Mapping:");

        // ---- ITERATE using entrySet ----
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue() + " seats");
        }

        // ---- LOOKUP capacity of a specific bogie ----
        System.out.println("\nCapacity of Sleeper: " + bogieCapacity.get("Sleeper"));
        System.out.println("Does AC Chair exist? " + bogieCapacity.containsKey("AC Chair"));

        // ---- UPDATE capacity ----
        bogieCapacity.put("Sleeper", 80); // update value
        System.out.println("\nUpdated Sleeper capacity: " + bogieCapacity.get("Sleeper"));

        System.out.println("\nTotal Bogies Mapped: " + bogieCapacity.size());
    }
}
