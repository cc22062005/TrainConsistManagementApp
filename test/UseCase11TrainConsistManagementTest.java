import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * UC11 - Validate Train ID & Cargo Code formats using Regular Expressions.
 */
public class UseCase11TrainConsistManagementTest {

    // Validates train ID format: T followed by 4 digits (e.g., T1234)
    private boolean isValidTrainId(String trainId) {
        return Pattern.matches("T\\d{4}", trainId);
    }

    // Validates cargo code format: 2 uppercase letters followed by 3 digits (e.g., AB123)
    private boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches("[A-Z]{2}\\d{3}", cargoCode);
    }

    @Test
    public void testValidTrainId() {
        assertTrue(isValidTrainId("T1234"), "T1234 should be a valid Train ID");
    }

    @Test
    public void testInvalidTrainIdMissingT() {
        assertFalse(isValidTrainId("1234"), "1234 without T prefix should be invalid");
    }

    @Test
    public void testInvalidTrainIdTooShort() {
        assertFalse(isValidTrainId("T123"), "T123 with only 3 digits should be invalid");
    }

    @Test
    public void testInvalidTrainIdTooLong() {
        assertFalse(isValidTrainId("T12345"), "T12345 with 5 digits should be invalid");
    }

    @Test
    public void testValidCargoCode() {
        assertTrue(isValidCargoCode("AB123"), "AB123 should be a valid Cargo Code");
    }

    @Test
    public void testInvalidCargoCodeLowercase() {
        assertFalse(isValidCargoCode("ab123"), "Lowercase letters should be invalid for Cargo Code");
    }

    @Test
    public void testInvalidCargoCodeMissingDigits() {
        assertFalse(isValidCargoCode("ABC"), "ABC without digits should be invalid");
    }

    @Test
    public void testInvalidCargoCodeSingleLetter() {
        assertFalse(isValidCargoCode("A123"), "Single letter prefix should be invalid");
    }

    @Test
    public void testEmptyTrainId() {
        assertFalse(isValidTrainId(""), "Empty string should be invalid Train ID");
    }

    @Test
    public void testEmptyCargoCode() {
        assertFalse(isValidCargoCode(""), "Empty string should be invalid Cargo Code");
    }
}
