import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Test class for UC8: Filter Passenger Bogies Using Streams
 *
 * Test Case Creation & Execution - IntelliJ (Java Project)
 * UC8 verifies Stream filter() operations on Bogie collections.
 *
 * @Test      -> Marks a test method
 * assertEquals(expected, actual) -> Checks result
 */
public class UseCase8TrainConsistManagementTest {

    // Helper inner class to simulate Bogie
    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Helper method: filter bogies with capacity > threshold
    List<Bogie> filterByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("TC01: Filter bogies with capacity > 60 - should return 3 bogies")
    void testFilterBogiesAbove60() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 64));
        bogies.add(new Bogie("First Class", 18));
        bogies.add(new Bogie("General", 90));
        bogies.add(new Bogie("Pantry", 20));

        // Expected Output
        int expectedCount = 3; // Sleeper(72), AC Chair(64), General(90)

        // Actual Output
        List<Bogie> result = filterByCapacity(bogies, 60);

        // Assertion
        assertEquals(expectedCount, result.size(),
                "Expected 3 bogies with capacity > 60");
    }

    @Test
    @DisplayName("TC02: Filter bogies with capacity > 80 - should return 1 bogie")
    void testFilterBogiesAbove80() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 64));
        bogies.add(new Bogie("General", 90));

        // Expected Output: only General(90)
        int expectedCount = 1;

        // Actual Output
        List<Bogie> result = filterByCapacity(bogies, 80);

        // Assertion
        assertEquals(expectedCount, result.size(),
                "Expected 1 bogie with capacity > 80");
        assertEquals("General", result.get(0).name,
                "Expected the bogie to be General");
    }

    @Test
    @DisplayName("TC03: Filter with high threshold - empty result")
    void testFilterReturnsEmpty() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 64));

        // Expected: no bogie has capacity > 100
        int expectedCount = 0;

        // Actual Output
        List<Bogie> result = filterByCapacity(bogies, 100);

        // Assertion
        assertTrue(result.isEmpty(),
                "Expected empty list when threshold exceeds all capacities");
        assertEquals(expectedCount, result.size());
    }

    @Test
    @DisplayName("TC04: Filter on empty list - should return empty list")
    void testFilterOnEmptyList() {
        // Input: empty list
        List<Bogie> bogies = new ArrayList<>();

        // Expected
        int expectedCount = 0;

        // Actual
        List<Bogie> result = filterByCapacity(bogies, 60);

        // Assertion
        assertEquals(expectedCount, result.size(),
                "Filtering empty list should return empty list");
    }

    @Test
    @DisplayName("TC05: Filter with threshold 0 - all bogies pass")
    void testFilterAllPass() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 64));
        bogies.add(new Bogie("Pantry", 20));

        // Expected: all 3 pass capacity > 0
        int expectedCount = 3;

        // Actual
        List<Bogie> result = filterByCapacity(bogies, 0);

        // Assertion
        assertEquals(expectedCount, result.size(),
                "All bogies should pass when threshold is 0");
    }
}
