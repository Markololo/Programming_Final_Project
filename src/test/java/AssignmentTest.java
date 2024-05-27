import org.example.Assignment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AssignmentTest {
    @Test
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment();
        assignment.setScores({2, 4});
    }

}
