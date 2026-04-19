import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * UC20 - Exception Handling During Search in the train consist.
 */
public class UseCase20TrainConsistManagementTest {

    private String searchBogie(List<String> bogieIds, String target) {
        if (bogieIds == null || bogieIds.isEmpty()) {
            throw new IllegalStateException("Train consist is empty. Cannot perform search.");
        }
        for (String id : bogieIds) {
            if (id.equals(target)) return id;
        }
        return null;
    }

    @Test
    public void testSearchThrowsExceptionOnEmptyList() {
        List<String> ids = new ArrayList<>();
        assertThrows(IllegalStateException.class, () -> searchBogie(ids, "B001"),
                "Should throw IllegalStateException when list is empty");
    }

    @Test
    public void testSearchThrowsExceptionOnNullList() {
        assertThrows(IllegalStateException.class, () -> searchBogie(null, "B001"),
                "Should throw IllegalStateException when list is null");
    }

    @Test
    public void testSearchFoundInNonEmptyList() {
        List<String> ids = List.of("B001", "B002", "B003");
        assertEquals("B002", searchBogie(ids, "B002"), "B002 should be found");
    }

    @Test
    public void testSearchNotFoundInNonEmptyList() {
        List<String> ids = List.of("B001", "B002", "B003");
        assertNull(searchBogie(ids, "B999"), "B999 should not be found");
    }

    @Test
    public void testExceptionMessageOnEmptyList() {
        List<String> ids = new ArrayList<>();
        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> searchBogie(ids, "B001"));
        assertEquals("Train consist is empty. Cannot perform search.", ex.getMessage());
    }

    @Test
    public void testSearchFirstElement() {
        List<String> ids = List.of("B001", "B002", "B003");
        assertEquals("B001", searchBogie(ids, "B001"), "First element should be found");
    }

    @Test
    public void testSearchLastElement() {
        List<String> ids = List.of("B001", "B002", "B003");
        assertEquals("B003", searchBogie(ids, "B003"), "Last element should be found");
    }

    @Test
    public void testSearchSingleElementFound() {
        List<String> ids = List.of("B001");
        assertEquals("B001", searchBogie(ids, "B001"), "Single element should be found");
    }

    @Test
    public void testSearchSingleElementNotFound() {
        List<String> ids = List.of("B001");
        assertNull(searchBogie(ids, "B002"), "B002 not found in single-element list");
    }

    @Test
    public void testSearchCaseSensitive() {
        List<String> ids = List.of("B001", "b001");
        assertEquals("B001", searchBogie(ids, "B001"), "Search should be case-sensitive");
        assertNull(searchBogie(ids, "b002"), "b002 should not be found");
    }
}
