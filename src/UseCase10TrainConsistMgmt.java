/**
 * ================================================
 * MAIN CLASS - UseCase10TrainConsistMgmt
 * ================================================
 *
 * Use Case 10: Count Total Seats in Train (reduce)
 *
 * Description:
 * This class aggregates seating capacities of all bogies
 * into a single total value using Stream reduction.
 *
 * At this stage, the application:
 * - Creates a list of Bogie objects with name and capacity
 * - Uses Stream map() to extract capacity values
 * - Uses reduce() to aggregate into total seat count
 * - Displays the total seating capacity
 *
 * @author Developer
 * @version 10.0
 */

import java.util.ArrayList;
import java.util.List;

public class UseCase10TrainConsistMgmt {

    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + "(" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("=======================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println("  " + b);
        }

        // ---- AGGREGATE USING REDUCE ----
        // map() extracts capacity field from Bogie object
        // reduce(0, Integer::sum) accumulates the total
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity: " + totalSeats + " seats");
        System.out.println("Total Bogies in Train: " + bogies.size());
        System.out.println("Average Capacity per Bogie: " + (totalSeats / bogies.size()) + " seats");
    }
}
