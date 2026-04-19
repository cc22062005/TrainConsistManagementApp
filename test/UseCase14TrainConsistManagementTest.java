import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UC14 - Handle Invalid Bogie Capacity using Exception Handling.
 */
public class UseCase14TrainConsistManagementTest {

    static class InvalidCapacityException extends RuntimeException {
        public InvalidCapacityException(String msg) { super(msg); }
    }

    private int validateCapacity(int capacity) {
        if (capacity <= 0) throw new InvalidCapacityException("Capacity must be positive: " + capacity);
        if (capacity > 200) throw new InvalidCapacityException("Capacity exceeds max limit: " + capacity);
        return capacity;
    }

    @Test
    public void testValidCapacity() {
        assertEquals(80, validateCapacity(80), "Valid capacity should return 80");
    }

    @Test
    public void testZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> validateCapacity(0),
            "Zero capacity should throw InvalidCapacityException");
    }

    @Test
    public void testNegativeCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> validateCapacity(-10),
            "Negative capacity should throw InvalidCapacityException");
    }

    @Test
    public void testOverMaxCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> validateCapacity(201),
            "Capacity over 200 should throw InvalidCapacityException");
    }

    @Test
    public void testBoundaryMinCapacity() {
        assertEquals(1, validateCapacity(1), "Minimum valid capacity should be 1");
    }

    @Test
    public void testBoundaryMaxCapacity() {
        assertEquals(200, validateCapacity(200), "Maximum valid capacity should be 200");
    }

    @Test
    public void testExceptionMessageForZero() {
        try {
            validateCapacity(0);
            fail("Should have thrown exception");
        } catch (InvalidCapacityException e) {
            assertTrue(e.getMessage().contains("positive"), "Message should mention positive");
        }
    }

    @Test
    public void testExceptionMessageForOverMax() {
        try {
            validateCapacity(999);
            fail("Should have thrown exception");
        } catch (InvalidCapacityException e) {
            assertTrue(e.getMessage().contains("max"), "Message should mention max limit");
        }
    }

    @Test
    public void testMidRangeCapacity() {
        assertEquals(100, validateCapacity(100), "Mid-range capacity 100 should be valid");
    }

    @Test
    public void testCapacity150() {
        assertEquals(150, validateCapacity(150), "Capacity 150 should be valid");
    }
}
