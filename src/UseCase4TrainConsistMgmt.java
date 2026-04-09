/**
 * ================================================
 * MAIN CLASS - UseCase4TrainConsistMgmt
 * ================================================
 *
 * Use Case 4: Maintain Ordered Bogie IDs (LinkedList)
 *
 * Description:
 * This class uses LinkedList to maintain the physical sequence
 * of bogies in the train consist. Bogies can be efficiently
 * inserted or removed from any position.
 *
 * At this stage, the application:
 * - Creates a LinkedList to represent the train consist
 * - Adds bogies: Engine, Sleeper, AC, Cargo, Guard
 * - Inserts a Pantry Car at position 2
 * - Removes the first and last bogie
 * - Displays the final ordered consist
 *
 * @author Developer
 * @version 4.0
 */

import java.util.LinkedList;
import java.util.List;

public class UseCase4TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("=======================================\n");

        // Create a LinkedList to represent the train consist
        // LinkedList maintains insertion order and allows fast inserts/deletes
        List<String> trainConsist = new LinkedList<>();

        // ---- ADD bogies to train ----
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist: " + trainConsist);

        // ---- INSERT Pantry Car at position 2 ----
        // add(index, element) inserts at that position, shifting others right
        trainConsist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at index 2: " + trainConsist);

        // ---- REMOVE first and last bogies ----
        ((LinkedList<String>) trainConsist).removeFirst();
        System.out.println("After removing first bogie (Engine): " + trainConsist);

        ((LinkedList<String>) trainConsist).removeLast();
        System.out.println("After removing last bogie (Guard): " + trainConsist);

        System.out.println("\nFinal Train Consist: " + trainConsist);
        System.out.println("Total Bogies: " + trainConsist.size());
    }
}
