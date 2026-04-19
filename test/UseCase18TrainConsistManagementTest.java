import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * UC18 - Linear Search for Bogie ID in the train consist.
 */
public class UseCase18TrainConsistManagementTest {

    private int linearSearch(String[] bogieIds, String target) {
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(target)) return i;
        }
        return -1;
    }

    @Test
    public void testSearchFoundFirst() {
        String[] ids = {"B001", "B002", "B003"};
        assertEquals(0, linearSearch(ids, "B001"), "B001 should be at index 0");
    }

    @Test
    public void testSearchFoundLast() {
        String[] ids = {"B001", "B002", "B003"};
        assertEquals(2, linearSearch(ids, "B003"), "B003 should be at index 2");
    }

    @Test
    public void testSearchFoundMiddle() {
        String[] ids = {"B001", "B002", "B003"};
        assertEquals(1, linearSearch(ids, "B002"), "B002 should be at index 1");
    }

    @Test
    public void testSearchNotFound() {
        String[] ids = {"B001", "B002", "B003"};
        assertEquals(-1, linearSearch(ids, "B999"), "B999 should not be found");
    }

    @Test
    public void testSearchEmptyArray() {
        String[] ids = {};
        assertEquals(-1, linearSearch(ids, "B001"), "Empty array should return -1");
    }

    @Test
    public void testSearchSingleElementFound() {
        String[] ids = {"B001"};
        assertEquals(0, linearSearch(ids, "B001"), "Single element found at index 0");
    }

    @Test
    public void testSearchSingleElementNotFound() {
        String[] ids = {"B001"};
        assertEquals(-1, linearSearch(ids, "B002"), "Single element not found returns -1");
    }

    @Test
    public void testSearchCaseSensitive() {
        String[] ids = {"B001", "b001", "B002"};
        assertEquals(0, linearSearch(ids, "B001"), "Search should be case-sensitive");
        assertEquals(1, linearSearch(ids, "b001"), "Lowercase b001 should be at index 1");
    }

    @Test
    public void testSearchDuplicateReturnsFirst() {
        String[] ids = {"B001", "B002", "B001"};
        assertEquals(0, linearSearch(ids, "B001"), "Duplicate search should return first occurrence");
    }

    @Test
    public void testSearchLargeArray() {
        String[] ids = new String[100];
        for (int i = 0; i < 100; i++) ids[i] = "B" + String.format("%03d", i);
        assertEquals(50, linearSearch(ids, "B050"), "B050 should be at index 50");
    }
}
