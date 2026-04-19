import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

/**
 * UC15 - Safe Cargo Assignment Using Optional.
 */
public class UseCase15TrainConsistManagementTest {

    private Optional<String> assignCargo(String cargoType) {
        if (cargoType == null || cargoType.isBlank()) return Optional.empty();
        return Optional.of(cargoType.toUpperCase());
    }

    private String getCargoOrDefault(Optional<String> cargo, String defaultValue) {
        return cargo.orElse(defaultValue);
    }

    @Test
    public void testValidCargoAssignment() {
        Optional<String> cargo = assignCargo("petroleum");
        assertTrue(cargo.isPresent(), "Cargo should be present for valid input");
    }

    @Test
    public void testCargoIsUpperCase() {
        Optional<String> cargo = assignCargo("petroleum");
        assertEquals("PETROLEUM", cargo.get(), "Cargo should be uppercase");
    }

    @Test
    public void testNullCargoReturnsEmpty() {
        Optional<String> cargo = assignCargo(null);
        assertFalse(cargo.isPresent(), "Null cargo should return empty Optional");
    }

    @Test
    public void testBlankCargoReturnsEmpty() {
        Optional<String> cargo = assignCargo("   ");
        assertFalse(cargo.isPresent(), "Blank cargo should return empty Optional");
    }

    @Test
    public void testGetCargoOrDefaultWhenPresent() {
        Optional<String> cargo = assignCargo("coal");
        assertEquals("COAL", getCargoOrDefault(cargo, "UNKNOWN"), "Should return assigned cargo");
    }

    @Test
    public void testGetCargoOrDefaultWhenEmpty() {
        Optional<String> cargo = assignCargo(null);
        assertEquals("UNKNOWN", getCargoOrDefault(cargo, "UNKNOWN"), "Should return default when empty");
    }

    @Test
    public void testEmptyStringCargoReturnsEmpty() {
        Optional<String> cargo = assignCargo("");
        assertFalse(cargo.isPresent(), "Empty string cargo should return empty Optional");
    }

    @Test
    public void testDifferentCargoTypes() {
        assertEquals("GRAIN", assignCargo("grain").orElse(""), "Grain cargo should be uppercase GRAIN");
        assertEquals("STEEL", assignCargo("steel").orElse(""), "Steel cargo should be uppercase STEEL");
    }

    @Test
    public void testOptionalMapTransformation() {
        Optional<String> cargo = assignCargo("timber");
        Optional<Integer> length = cargo.map(String::length);
        assertTrue(length.isPresent(), "Mapped length should be present");
        assertEquals(6, length.get(), "TIMBER has length 6");
    }

    @Test
    public void testOptionalEmptyMap() {
        Optional<String> cargo = assignCargo(null);
        Optional<Integer> length = cargo.map(String::length);
        assertFalse(length.isPresent(), "Mapped length from empty should be empty");
    }
}
