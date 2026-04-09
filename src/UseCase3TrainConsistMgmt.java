/**
 * ================================================
 * MAIN CLASS - UseCase3TrainConsistMgmt
 * ================================================
 *
 * Use Case 3: Track Unique Bogie IDs (Set - HashSet)
 *
 * Description:
 * This class enforces uniqueness of bogie IDs using HashSet.
 * Prevents duplicate bogie registrations in the train consist.
 *
 * At this stage, the application:
 * - Stores bogie IDs in a HashSet
 * - Automatically ignores duplicate entries
 * - Displays only unique bogie IDs
 *
 * @author Developer
 * @version 3.0
 */

import java.util.HashSet;
import java.util.Set;

public class UseCase3TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("=======================================\n");

        // Create a Set to store unique bogie IDs
        // HashSet stores only unique values
        Set<String> bogies = new HashSet<>();

        // ---- ADD IDs (including duplicates) ----
        // add() inserts bogie IDs into the set
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");
        // Duplicate entries will be ignored internally by HashSet
        bogies.add("BG101"); // Duplicate entry
        bogies.add("BG102"); // Duplicate entry

        System.out.println("Bogie IDs in Train (Unique only): " + bogies);
        System.out.println("Total Unique Bogies: " + bogies.size());

        // Check if a specific bogie ID exists
        System.out.println("\nIs BG103 registered? " + bogies.contains("BG103"));
        System.out.println("Is BG999 registered? " + bogies.contains("BG999"));

        // Remove a bogie ID
        bogies.remove("BG104");
        System.out.println("\nAfter removing BG104: " + bogies);
        System.out.println("Total Unique Bogies: " + bogies.size());
    }
}
