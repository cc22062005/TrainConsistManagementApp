import java.util.HashMap;
import java.util.Map;

public class UseCase6TrainConsistManagement {
    public static void main(String[] args) {
        // UC6: Map Bogie to Capacity (HashMap)
        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        // Insert capacity values for bogies
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 64);
        bogieCapacity.put("First Class", 18);
        bogieCapacity.put("General", 90);

        System.out.println("Bogie Capacity Mapping:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue() + " seats");
        }
    }
}
