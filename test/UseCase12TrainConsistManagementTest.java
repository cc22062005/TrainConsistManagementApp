import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * UC12 - Safety Compliance Check for Bogies.
 * Tests whether bogies meet safety standards based on capacity limits.
 */
public class UseCase12TrainConsistManagementTest {

    static class Bogie {
        String id;
        String type;
        int capacity;
        boolean safetyApproved;
        Bogie(String id, String type, int capacity, boolean safetyApproved) {
            this.id = id; this.type = type;
            this.capacity = capacity; this.safetyApproved = safetyApproved;
        }
    }

    private boolean isCompliant(Bogie b) {
        return b.safetyApproved && b.capacity > 0 && b.capacity <= 100;
    }

    private long countCompliant(List<Bogie> bogies) {
        return bogies.stream().filter(this::isCompliant).count();
    }

    @Test
    public void testSafetyApprovedBogieIsCompliant() {
        Bogie b = new Bogie("B001", "Passenger", 60, true);
        assertTrue(isCompliant(b), "Approved bogie with valid capacity should be compliant");
    }

    @Test
    public void testNotApprovedBogieIsNonCompliant() {
        Bogie b = new Bogie("B002", "Cargo", 50, false);
        assertFalse(isCompliant(b), "Non-approved bogie should fail compliance");
    }

    @Test
    public void testZeroCapacityIsNonCompliant() {
        Bogie b = new Bogie("B003", "Passenger", 0, true);
        assertFalse(isCompliant(b), "Bogie with zero capacity should fail compliance");
    }

    @Test
    public void testExceedingCapacityIsNonCompliant() {
        Bogie b = new Bogie("B004", "Passenger", 150, true);
        assertFalse(isCompliant(b), "Bogie exceeding max capacity should fail compliance");
    }

    @Test
    public void testCountCompliantBogies() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B001", "Passenger", 60, true),
            new Bogie("B002", "Cargo", 50, false),
            new Bogie("B003", "Passenger", 80, true)
        );
        assertEquals(2, countCompliant(bogies), "Should count 2 compliant bogies");
    }

    @Test
    public void testAllCompliant() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B001", "Passenger", 60, true),
            new Bogie("B002", "Passenger", 70, true)
        );
        assertEquals(2, countCompliant(bogies), "All bogies should be compliant");
    }

    @Test
    public void testNoneCompliant() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B001", "Cargo", 50, false),
            new Bogie("B002", "Cargo", 0, true)
        );
        assertEquals(0, countCompliant(bogies), "No bogie should be compliant");
    }

    @Test
    public void testEmptyListCompliance() {
        List<Bogie> bogies = Arrays.asList();
        assertEquals(0, countCompliant(bogies), "Empty list should have zero compliant bogies");
    }

    @Test
    public void testBoundaryCapacityCompliant() {
        Bogie b = new Bogie("B005", "Passenger", 100, true);
        assertTrue(isCompliant(b), "Bogie with exactly max capacity should be compliant");
    }

    @Test
    public void testBoundaryCapacityOneAboveMax() {
        Bogie b = new Bogie("B006", "Passenger", 101, true);
        assertFalse(isCompliant(b), "Bogie with capacity 101 should fail compliance");
    }
}
