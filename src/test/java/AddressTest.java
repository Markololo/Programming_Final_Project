import org.example.Address;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AddressTest {
    @Test
    public void testIsPostalCodeValid1() {
        String input = "hello";
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsPostalCodeValid2() {
        String input = "h1h2g4";
        boolean expResult = true;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsPostalCodeValid3() {
        String input = "h1j 3j4";
        boolean expResult = true;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsPostalCodeValid4() {
        String input = null;
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsPostalCodeValid5() {
        String input = "h1h  1h1";
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testToTitleCase6() {
        String input = "";
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }
}
