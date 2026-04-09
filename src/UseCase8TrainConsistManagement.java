import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (capacity=" + capacity + ")";
    }
}

public class UseCase8TrainConsistManagement {
    public static void main(String[] args) {
        // UC8: Filter Passenger Bogies Using Streams
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 64));
        bogies.add(new Bogie("First Class", 18));
        bogies.add(new Bogie("General", 90));
        bogies.add(new Bogie("Pantry", 20));

        System.out.println("Before Filtering:");
        for (Bogie b : bogies) {
            System.out.println("  " + b);
        }

        // Filter bogies with capacity > 60
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println("  " + b);
        }
    }
}
