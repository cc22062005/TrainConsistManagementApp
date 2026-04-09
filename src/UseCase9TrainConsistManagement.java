import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class BogieType {
    String name;
    String type;
    int capacity;

    BogieType(String name, String type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (capacity=" + capacity + ")";
    }
}

public class UseCase9TrainConsistManagement {
    public static void main(String[] args) {
        // UC9: Group Bogies by Type (Collectors.groupingBy)
        List<BogieType> bogies = new ArrayList<>();
        bogies.add(new BogieType("Sleeper", "Passenger", 72));
        bogies.add(new BogieType("AC Chair", "Passenger", 64));
        bogies.add(new BogieType("First Class", "Passenger", 18));
        bogies.add(new BogieType("Cargo A", "Freight", 0));
        bogies.add(new BogieType("Cargo B", "Freight", 0));
        bogies.add(new BogieType("Pantry", "Service", 10));

        // Group bogies by type
        Map<String, List<BogieType>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        System.out.println("Grouped Bogies by Type:");
        for (Map.Entry<String, List<BogieType>> entry : grouped.entrySet()) {
            System.out.println("\n  Type: " + entry.getKey());
            for (BogieType b : entry.getValue()) {
                System.out.println("    " + b);
            }
        }
    }
}
