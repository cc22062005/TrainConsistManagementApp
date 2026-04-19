import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

/**
 * UC17 - Sort Bogie Names Using Arrays.sort.
 */
public class UseCase17TrainConsistManagementTest {

    private String[] sortBogieNamesAsc(String[] names) {
        String[] sorted = Arrays.copyOf(names, names.length);
        Arrays.sort(sorted);
        return sorted;
    }

    private String[] sortBogieNamesDesc(String[] names) {
        String[] sorted = Arrays.copyOf(names, names.length);
        Arrays.sort(sorted, (a, b) -> b.compareTo(a));
        return sorted;
    }

    @Test
    public void testSortNamesAscending() {
        String[] names = {"Charlie", "Alpha", "Bravo"};
        String[] sorted = sortBogieNamesAsc(names);
        assertEquals("Alpha", sorted[0], "First name should be Alpha");
    }

    @Test
    public void testSortNamesDescending() {
        String[] names = {"Charlie", "Alpha", "Bravo"};
        String[] sorted = sortBogieNamesDesc(names);
        assertEquals("Charlie", sorted[0], "First name should be Charlie");
    }

    @Test
    public void testSortAscendingOrder() {
        String[] names = {"Zeta", "Alpha", "Mango"};
        String[] sorted = sortBogieNamesAsc(names);
        assertEquals("Alpha", sorted[0]);
        assertEquals("Mango", sorted[1]);
        assertEquals("Zeta", sorted[2]);
    }

    @Test
    public void testSortDescendingOrder() {
        String[] names = {"Zeta", "Alpha", "Mango"};
        String[] sorted = sortBogieNamesDesc(names);
        assertEquals("Zeta", sorted[0]);
        assertEquals("Mango", sorted[1]);
        assertEquals("Alpha", sorted[2]);
    }

    @Test
    public void testSortSingleElement() {
        String[] names = {"Solo"};
        String[] sorted = sortBogieNamesAsc(names);
        assertEquals(1, sorted.length, "Single element array length should be 1");
        assertEquals("Solo", sorted[0]);
    }

    @Test
    public void testSortPreservesOriginal() {
        String[] names = {"Zeta", "Alpha", "Mango"};
        sortBogieNamesAsc(names);
        assertEquals("Zeta", names[0], "Original array should not be modified");
    }

    @Test
    public void testSortAlreadySorted() {
        String[] names = {"Alpha", "Bravo", "Charlie"};
        String[] sorted = sortBogieNamesAsc(names);
        assertArrayEquals(new String[]{"Alpha", "Bravo", "Charlie"}, sorted);
    }

    @Test
    public void testSortReverseSorted() {
        String[] names = {"Charlie", "Bravo", "Alpha"};
        String[] sorted = sortBogieNamesAsc(names);
        assertEquals("Alpha", sorted[0]);
    }

    @Test
    public void testSortTwoElements() {
        String[] names = {"Zeta", "Alpha"};
        String[] sorted = sortBogieNamesAsc(names);
        assertEquals("Alpha", sorted[0]);
        assertEquals("Zeta", sorted[1]);
    }

    @Test
    public void testSortResultLength() {
        String[] names = {"D", "C", "A", "B"};
        String[] sorted = sortBogieNamesAsc(names);
        assertEquals(4, sorted.length, "Sorted array should have same length");
    }
}
