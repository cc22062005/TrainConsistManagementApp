import java.util.LinkedHashSet;

public class UseCase5TrainConsistManagement {
    public static void main(String[] args) {
        // UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        // Attach bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempt to attach a duplicate bogie
        formation.add("Sleeper"); // Duplicate - should be ignored

        System.out.println("Train Formation (Insertion Order Preserved):");
        System.out.println(formation);

        System.out.println("\nBogies in formation:");
        for (String bogie : formation) {
            System.out.println("  " + bogie);
        }
    }
}
