import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class CourseTest {
    @Test
    public void testCalcStudentAvg1() {
        Course course = new Course();
        Student student1 = new Student();
        Student student2 = new Student();
        course.getRegisteredStudents().add(student1);
        course.getRegisteredStudents().add(student2);

        Assignment assignment1 = new Assignment();
        assignment1.setWeight(0.2);
        assignment1.setScores(new ArrayList<>(List.of(90, 80)));

        Assignment assignment2 = new Assignment();
        assignment2.setWeight(0.3);
        assignment2.setScores(new ArrayList<>(List.of(70, 60)));

        course.getAssignments().add(assignment1);
        course.getAssignments().add(assignment2);

        int[] expResult = {(int) Math.round(90 * 0.2 + 70 * 0.3), (int) Math.round(80 * 0.2 + 60 * 0.3)};
        int[] result = course.calcStudentsAvg();
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testCalcStudentAvg2() {
        Course course = new Course();
        Student student1 = new Student();
        Student student2 = new Student();
        course.getRegisteredStudents().add(student1);
        course.getRegisteredStudents().add(student2);

        Assignment assignment1 = new Assignment();
        assignment1.setWeight(0.2);
        assignment1.setScores(new ArrayList<>(List.of(-1, 80)));

        Assignment assignment2 = new Assignment();
        assignment2.setWeight(0.3);
        assignment2.setScores(new ArrayList<>(List.of(70, 60)));

        course.getAssignments().add(assignment1);
        course.getAssignments().add(assignment2);

        int[] expResult = {(int) Math.round(0 * 0.2 + 70 * 0.3), (int) Math.round(80 * 0.2 + 60 * 0.3)};
        int[] result = course.calcStudentsAvg();
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testCalcStudentAvg3() {
        Course course = new Course();
        Student student1 = new Student();
        Student student2 = new Student();
        course.getRegisteredStudents().add(student1);
        course.getRegisteredStudents().add(student2);

        Assignment assignment1 = new Assignment();
        assignment1.setWeight(0.2);
        assignment1.setScores(new ArrayList<>(List.of(90)));

        Assignment assignment2 = new Assignment();
        assignment2.setWeight(0.3);
        assignment2.setScores(new ArrayList<>(List.of(70, 60)));

        course.getAssignments().add(assignment1);
        course.getAssignments().add(assignment2);

        int[] expResult = {(int) Math.round(90 * 0.2 + 70 * 0.3), (int) Math.round(0 * 0.2 + 60 * 0.3)};
        int[] result = course.calcStudentsAvg();
        assertArrayEquals(expResult, result);
    }
}
