/**
 * ================================================
 * MAIN CLASS - UseCase7TrainConsistMgmt
 * ================================================
 *
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 *
 * Description:
 * This class models passenger bogies as objects and sorts
 * them by seating capacity using a custom Comparator.
 *
 * At this stage, the application:
 * - Creates Bogie objects with name and capacity
 * - Stores them in a List
 * - Sorts using Comparator.comparingInt()
 * - Displays bogies in ascending order of capacity
 *
 * @author Developer
 * @version 7.0
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UseCase7TrainConsistMgmt {

    // Bogie model class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC7 - Sort Bogies by Capacity ");
        System.out.println("=======================================\n");

        // Create passenger bogie objects
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 72));

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println("  " + b);
        }

        // ---- SORT using Comparator ----
        // Comparator.comparingInt() defines sort order by capacity field
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (ascending capacity):");
        for (Bogie b : bogies) {
            System.out.println("  " + b);
        }

        // ---- SORT in descending order ----
        bogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());

        System.out.println("\nAfter Sorting (descending capacity):");
        for (Bogie b : bogies) {
            System.out.println("  " + b);
        }
    }
}
