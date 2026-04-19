import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

/**
 * UC19 - Binary Search for Bogie ID in the train consist.
 */
public class UseCase19TrainConsistManagementTest {

    private int binarySearch(String[] bogieIds, String target) {
        int low = 0, high = bogieIds.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = bogieIds[mid].compareTo(target);
            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    @Test
    public void testBinarySearchFound() {
        String[] ids = {"B001", "B002", "B003", "B004", "B005"};
        assertEquals(2, binarySearch(ids, "B003"), "B003 should be at index 2");
    }

    @Test
    public void testBinarySearchNotFound() {
        String[] ids = {"B001", "B002", "B003"};
        assertEquals(-1, binarySearch(ids, "B999"), "B999 should not be found");
    }

    @Test
    public void testBinarySearchFirstElement() {
        String[] ids = {"B001", "B002", "B003"};
        assertEquals(0, binarySearch(ids, "B001"), "B001 should be at index 0");
    }

    @Test
    public void testBinarySearchLastElement() {
        String[] ids = {"B001", "B002", "B003"};
        assertEquals(2, binarySearch(ids, "B003"), "B003 should be at index 2");
    }

    @Test
    public void testBinarySearchSingleElementFound() {
        String[] ids = {"B001"};
        assertEquals(0, binarySearch(ids, "B001"), "Single element found at index 0");
    }

    @Test
    public void testBinarySearchSingleElementNotFound() {
        String[] ids = {"B001"};
        assertEquals(-1, binarySearch(ids, "B002"), "Single element not found returns -1");
    }

    @Test
    public void testBinarySearchCaseSensitive() {
        String[] ids = {"B001", "b001", "b002"};
        assertEquals(0, binarySearch(ids, "B001"), "Search should be case-sensitive");
    }

    @Test
    public void testBinarySearchLargeArray() {
        String[] ids = new String[100];
        for (int i = 0; i < 100; i++) ids[i] = "B" + String.format("%03d", i);
        assertEquals(50, binarySearch(ids, "B050"), "B050 should be at index 50");
    }

    @Test
    public void testBinarySearchEmptyArray() {
        String[] ids = {};
        assertEquals(-1, binarySearch(ids, "B001"), "Empty array should return -1");
    }

    @Test
    public void testBinarySearchMiddleElement() {
        String[] ids = {"B001", "B002", "B003", "B004", "B005"};
        assertEquals(2, binarySearch(ids, "B003"), "Middle element should be found");
    }
}
