import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * UC13 - Performance Comparison of ArrayList vs LinkedList for Bogie Operations.
 */
public class UseCase13TrainConsistManagementTest {

    static class Bogie {
        String id;
        String type;
        int capacity;
        Bogie(String id, String type, int capacity) {
            this.id = id; this.type = type; this.capacity = capacity;
        }
    }

    private List<Bogie> createArrayList(int size) {
        List<Bogie> list = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(new Bogie("B" + i, "Passenger", 50 + i));
        return list;
    }

    private List<Bogie> createLinkedList(int size) {
        List<Bogie> list = new java.util.LinkedList<>();
        for (int i = 0; i < size; i++)
            list.add(new Bogie("B" + i, "Cargo", 60 + i));
        return list;
    }

    @Test
    public void testArrayListSize() {
        List<Bogie> list = createArrayList(5);
        assertEquals(5, list.size(), "ArrayList should have 5 bogies");
    }

    @Test
    public void testLinkedListSize() {
        List<Bogie> list = createLinkedList(5);
        assertEquals(5, list.size(), "LinkedList should have 5 bogies");
    }

    @Test
    public void testArrayListGetByIndex() {
        List<Bogie> list = createArrayList(3);
        assertEquals("B0", list.get(0).id, "First bogie ID should be B0");
    }

    @Test
    public void testLinkedListGetByIndex() {
        List<Bogie> list = createLinkedList(3);
        assertEquals("B0", list.get(0).id, "First bogie ID should be B0");
    }

    @Test
    public void testArrayListAddRemove() {
        List<Bogie> list = createArrayList(3);
        list.add(new Bogie("BX", "Passenger", 70));
        assertEquals(4, list.size(), "After add, size should be 4");
        list.remove(0);
        assertEquals(3, list.size(), "After remove, size should be 3");
    }

    @Test
    public void testLinkedListAddRemove() {
        List<Bogie> list = createLinkedList(3);
        list.add(new Bogie("BX", "Cargo", 80));
        assertEquals(4, list.size(), "After add, size should be 4");
        list.remove(0);
        assertEquals(3, list.size(), "After remove, size should be 3");
    }

    @Test
    public void testArrayListCapacitySum() {
        List<Bogie> list = createArrayList(3);
        int total = list.stream().mapToInt(b -> b.capacity).sum();
        assertEquals(153, total, "Total capacity of 3 bogies starting at 50 should be 153");
    }

    @Test
    public void testLinkedListCapacitySum() {
        List<Bogie> list = createLinkedList(3);
        int total = list.stream().mapToInt(b -> b.capacity).sum();
        assertEquals(183, total, "Total capacity of 3 bogies starting at 60 should be 183");
    }

    @Test
    public void testEmptyArrayList() {
        List<Bogie> list = new java.util.ArrayList<>();
        assertTrue(list.isEmpty(), "New ArrayList should be empty");
    }

    @Test
    public void testEmptyLinkedList() {
        List<Bogie> list = new java.util.LinkedList<>();
        assertTrue(list.isEmpty(), "New LinkedList should be empty");
    }
}
