import java.util.LinkedList;

public class UseCase4TrainConsistManagement {
    public static void main(String[] args) {
        // UC4: Maintain Ordered Bogie IDs (LinkedList)
        LinkedList<String> consist = new LinkedList<>();

        // Add bogies
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        System.out.println("Initial Train Consist:");
        for (String bogie : consist) {
            System.out.println("  " + bogie);
        }

        // Insert Pantry Car at position 2
        consist.add(2, "Pantry Car");
        System.out.println("\nAfter inserting Pantry Car at position 2:");
        for (String bogie : consist) {
            System.out.println("  " + bogie);
        }

        // Remove first and last bogie
        consist.removeFirst();
        consist.removeLast();

        System.out.println("\nFinal Train Consist (after removing first and last):");
        for (String bogie : consist) {
            System.out.println("  " + bogie);
        }
    }
}
