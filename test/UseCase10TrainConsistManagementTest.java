import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for UC10: Count Total Seats in Train (reduce)
 *
 * Test Case Creation & Execution - IntelliJ (Java Project)
 * UC10 verifies Stream map() + reduce() for seat aggregation.
 *
 * @Test      -> Marks a test method
 * assertEquals(expected, actual) -> Checks result
 */
public class UseCase10TrainConsistManagementTest {

    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    int countTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    @DisplayName("TC01: Total seats for 4 bogies should be 222")
    void testTotalSeatsForFourBogies() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Expected: 72 + 56 + 24 + 70 = 222
        int expected = 222;

        // Actual
        int actual = countTotalSeats(bogies);

        // Assertion
        assertEquals(expected, actual,
                "Total seats should be 222");
    }

    @Test
    @DisplayName("TC02: Total seats for empty list should be 0")
    void testTotalSeatsEmptyList() {
        // Input: empty
        List<Bogie> bogies = new ArrayList<>();

        // Expected
        int expected = 0;

        // Actual
        int actual = countTotalSeats(bogies);

        // Assertion
        assertEquals(expected, actual,
                "Total seats for empty list should be 0");
    }

    @Test
    @DisplayName("TC03: Single bogie - total seats equals its capacity")
    void testSingleBogie() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("General", 90));

        // Expected
        int expected = 90;

        // Actual
        int actual = countTotalSeats(bogies);

        // Assertion
        assertEquals(expected, actual,
                "Single bogie total should equal its capacity");
    }

    @Test
    @DisplayName("TC04: All zero capacity bogies - total should be 0")
    void testAllZeroCapacityBogies() {
        // Input: freight bogies with 0 capacity
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Cargo A", 0));
        bogies.add(new Bogie("Cargo B", 0));
        bogies.add(new Bogie("Cargo C", 0));

        // Expected
        int expected = 0;

        // Actual
        int actual = countTotalSeats(bogies);

        // Assertion
        assertEquals(expected, actual,
                "All zero capacity should sum to 0");
    }

    @Test
    @DisplayName("TC05: Mixed capacity bogies - correct total")
    void testMixedCapacityBogies() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 64));
        bogies.add(new Bogie("Pantry", 10));
        bogies.add(new Bogie("Cargo", 0));

        // Expected: 72 + 64 + 10 + 0 = 146
        int expected = 146;

        // Actual
        int actual = countTotalSeats(bogies);

        // Assertion
        assertEquals(expected, actual,
                "Mixed capacity total should be 146");
    }

    @Test
    @DisplayName("TC06: Average capacity calculation")
    void testAverageCapacity() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        int total = countTotalSeats(bogies);
        int expectedAverage = 55; // 222 / 4 = 55

        // Actual
        int actualAverage = total / bogies.size();

        // Assertion
        assertEquals(expectedAverage, actualAverage,
                "Average capacity should be 55");
    }
}
