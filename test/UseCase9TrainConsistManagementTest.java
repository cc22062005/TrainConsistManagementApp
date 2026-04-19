import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Test class for UC9: Group Bogies by Type
 *
 * Test Case Creation & Execution - IntelliJ (Java Project)
 * UC9 verifies Collectors.groupingBy() on Bogie collections.
 *
 * @Test      -> Marks a test method
 * assertEquals(expected, actual) -> Checks result
 */
public class UseCase9TrainConsistManagementTest {

    static class Bogie {
        String name;
        String type;
        int capacity;
        Bogie(String name, String type, int capacity) {
            this.name = name;
            this.type = type;
            this.capacity = capacity;
        }
    }

    Map<String, List<Bogie>> groupByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));
    }

    @Test
    @DisplayName("TC01: Group mixed bogies - should create 3 groups")
    void testGroupByTypeCreatesThreeGroups() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", "Passenger", 72));
        bogies.add(new Bogie("AC Chair", "Passenger", 64));
        bogies.add(new Bogie("Cargo A", "Freight", 0));
        bogies.add(new Bogie("Cargo B", "Freight", 0));
        bogies.add(new Bogie("Pantry", "Service", 10));

        // Expected: 3 groups (Passenger, Freight, Service)
        int expectedGroupCount = 3;

        // Actual
        Map<String, List<Bogie>> result = groupByType(bogies);

        // Assertion
        assertEquals(expectedGroupCount, result.size(),
                "Expected 3 bogie type groups");
    }

    @Test
    @DisplayName("TC02: Passenger group should have 2 bogies")
    void testPassengerGroupSize() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", "Passenger", 72));
        bogies.add(new Bogie("AC Chair", "Passenger", 64));
        bogies.add(new Bogie("Cargo A", "Freight", 0));
        bogies.add(new Bogie("Pantry", "Service", 10));

        // Expected: Passenger group has 2 members
        int expectedPassengerCount = 2;

        // Actual
        Map<String, List<Bogie>> result = groupByType(bogies);

        // Assertion
        assertTrue(result.containsKey("Passenger"),
                "Should contain Passenger group");
        assertEquals(expectedPassengerCount, result.get("Passenger").size(),
                "Passenger group should have 2 bogies");
    }

    @Test
    @DisplayName("TC03: Group single type - should create 1 group")
    void testGroupSingleType() {
        // Input: all same type
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", "Passenger", 72));
        bogies.add(new Bogie("AC Chair", "Passenger", 64));
        bogies.add(new Bogie("General", "Passenger", 90));

        // Expected: only 1 group
        int expectedGroupCount = 1;

        // Actual
        Map<String, List<Bogie>> result = groupByType(bogies);

        // Assertion
        assertEquals(expectedGroupCount, result.size(),
                "All same type bogies should form 1 group");
        assertEquals(3, result.get("Passenger").size(),
                "Passenger group should have all 3 bogies");
    }

    @Test
    @DisplayName("TC04: Group empty list - should return empty map")
    void testGroupEmptyList() {
        // Input: empty
        List<Bogie> bogies = new ArrayList<>();

        // Expected: empty map
        Map<String, List<Bogie>> result = groupByType(bogies);

        // Assertion
        assertTrue(result.isEmpty(),
                "Grouping empty list should return empty map");
    }

    @Test
    @DisplayName("TC05: Freight group should have correct bogies")
    void testFreightGroupContent() {
        // Input
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", "Passenger", 72));
        bogies.add(new Bogie("Cargo A", "Freight", 0));
        bogies.add(new Bogie("Cargo B", "Freight", 0));

        // Actual
        Map<String, List<Bogie>> result = groupByType(bogies);

        // Assertion
        assertEquals(2, result.get("Freight").size(),
                "Freight group should have 2 bogies");
        assertEquals("Cargo A", result.get("Freight").get(0).name,
                "First freight bogie should be Cargo A");
    }
}
