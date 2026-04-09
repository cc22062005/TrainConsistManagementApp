/**
 * ================================================
 * MAIN CLASS - UseCase5TrainConsistMgmt
 * ================================================
 *
 * Use Case 5: Preserve Insertion Order of Bogies (LinkedHashSet)
 *
 * Description:
 * This class uses LinkedHashSet to store bogie names while
 * preserving the order of insertion and enforcing uniqueness.
 *
 * At this stage, the application:
 * - Creates a LinkedHashSet for the train formation
 * - Adds bogies: Engine, Sleeper, Cargo, Guard
 * - Attempts to add a duplicate (Sleeper) - will be ignored
 * - Displays bogies in insertion order
 *
 * @author Developer
 * @version 5.0
 */

import java.util.LinkedHashSet;
import java.util.Set;

public class UseCase5TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC5 - Preserve Insertion Order ");
        System.out.println("=======================================\n");

        // LinkedHashSet: maintains insertion order + no duplicates
        Set<String> trainFormation = new LinkedHashSet<>();

        // ---- ADD bogies in sequence ----
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Train Formation (after initial additions): " + trainFormation);

        // ---- ATTEMPT DUPLICATE (Sleeper again) ----
        boolean added = trainFormation.add("Sleeper"); // duplicate ignored
        System.out.println("\nAttempting to add duplicate Sleeper...");
        System.out.println("Was Sleeper added again? " + added);

        System.out.println("\nFinal Train Formation (insertion order): " + trainFormation);
        System.out.println("Total Bogies: " + trainFormation.size());
    }
}
