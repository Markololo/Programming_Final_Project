import org.example.Address;
import org.example.util.Util;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UtilTest {
    @Test
    public void testToTitleCase1() {
        String input = "hello";
        String expResult = "Hello";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testToTitleCase2() {
        String input = "";
        String expResult = "";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testToTitleCase3() {
        String input = null;
        String expResult = null;
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testToTitleCase4() {
        String input = "hello there";
        String expResult = "Hello There";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testToTitleCase5() {
        String input = "heLlo thEre";
        String expResult = "Hello There";
        String result = Util.toTitleCase(input);
        assertEquals(expResult, result);
    }
}
