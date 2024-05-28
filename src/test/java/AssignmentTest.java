import org.example.Assignment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AssignmentTest {
    @Test
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Test Assignment", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        scores.add(100);
        assignment.setScores(scores);
        double expectedResult = 90;
        double result = assignment.getAssignmentAvg();
        assertEquals(expectedResult, result);
    }
    @Test
    public void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Test Assignment", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(null);
        scores.add(90);
        scores.add(100);
        assignment.setScores(scores);
        double expectedResult = 95;
        double result = assignment.getAssignmentAvg();
        assertEquals(expectedResult, result);
    }
    @Test
    public void testCalcAssignmentAvg3() {
        Assignment assignment = new Assignment("Test Assignment", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(null);
        scores.add(null);
        scores.add(null);
        assignment.setScores(scores);
        double expectedResult = 0;
        double result = assignment.getAssignmentAvg();
        assertEquals(expectedResult, result);
    }
}
