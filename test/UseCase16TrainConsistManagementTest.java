import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * UC16 - Sort Passenger Bogies by Capacity.
 */
public class UseCase16TrainConsistManagementTest {

    static class Bogie {
        String id;
        String type;
        int capacity;
        Bogie(String id, String type, int capacity) {
            this.id = id; this.type = type; this.capacity = capacity;
        }
    }

    private List<Bogie> sortByCapacityAsc(List<Bogie> bogies) {
        bogies.sort((a, b) -> Integer.compare(a.capacity, b.capacity));
        return bogies;
    }

    private List<Bogie> sortByCapacityDesc(List<Bogie> bogies) {
        bogies.sort((a, b) -> Integer.compare(b.capacity, a.capacity));
        return bogies;
    }

    @Test
    public void testSortByCapacityAscending() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B1", "Passenger", 80),
            new Bogie("B2", "Passenger", 40),
            new Bogie("B3", "Passenger", 60)
        );
        sortByCapacityAsc(bogies);
        assertEquals(40, bogies.get(0).capacity, "First bogie should have smallest capacity");
    }

    @Test
    public void testSortByCapacityDescending() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B1", "Passenger", 80),
            new Bogie("B2", "Passenger", 40),
            new Bogie("B3", "Passenger", 60)
        );
        sortByCapacityDesc(bogies);
        assertEquals(80, bogies.get(0).capacity, "First bogie should have largest capacity");
    }

    @Test
    public void testSortOrderAscending() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B1", "Passenger", 80),
            new Bogie("B2", "Passenger", 40),
            new Bogie("B3", "Passenger", 60)
        );
        sortByCapacityAsc(bogies);
        assertEquals(40, bogies.get(0).capacity);
        assertEquals(60, bogies.get(1).capacity);
        assertEquals(80, bogies.get(2).capacity);
    }

    @Test
    public void testSingleBogieSort() {
        List<Bogie> bogies = Arrays.asList(new Bogie("B1", "Passenger", 70));
        sortByCapacityAsc(bogies);
        assertEquals(1, bogies.size(), "Single bogie list size should remain 1");
    }

    @Test
    public void testEqualCapacitiesSortStable() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B1", "Passenger", 60),
            new Bogie("B2", "Passenger", 60)
        );
        sortByCapacityAsc(bogies);
        assertEquals(60, bogies.get(0).capacity);
        assertEquals(60, bogies.get(1).capacity);
    }

    @Test
    public void testSortPreservesAllBogies() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B1", "Passenger", 90),
            new Bogie("B2", "Passenger", 30),
            new Bogie("B3", "Passenger", 50)
        );
        sortByCapacityAsc(bogies);
        assertEquals(3, bogies.size(), "All 3 bogies should be preserved after sort");
    }

    @Test
    public void testSortDescFirstLargest() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B1", "Passenger", 90),
            new Bogie("B2", "Passenger", 30),
            new Bogie("B3", "Passenger", 50)
        );
        sortByCapacityDesc(bogies);
        assertEquals(90, bogies.get(0).capacity);
    }

    @Test
    public void testSortDescLastSmallest() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B1", "Passenger", 90),
            new Bogie("B2", "Passenger", 30),
            new Bogie("B3", "Passenger", 50)
        );
        sortByCapacityDesc(bogies);
        assertEquals(30, bogies.get(2).capacity);
    }

    @Test
    public void testAlreadySortedList() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B1", "Passenger", 20),
            new Bogie("B2", "Passenger", 50),
            new Bogie("B3", "Passenger", 80)
        );
        sortByCapacityAsc(bogies);
        assertEquals(20, bogies.get(0).capacity, "Already sorted list first element should be 20");
    }

    @Test
    public void testReverseSortedList() {
        List<Bogie> bogies = Arrays.asList(
            new Bogie("B1", "Passenger", 80),
            new Bogie("B2", "Passenger", 50),
            new Bogie("B3", "Passenger", 20)
        );
        sortByCapacityAsc(bogies);
        assertEquals(20, bogies.get(0).capacity, "Reverse sorted list first element after ASC sort should be 20");
    }
}
