import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CourseTest {
    @Test
    public void testCalcStudentAvg1() {
        Address address = new Address(123, "Main St", "Anytown", "State", "12345", "Country");
        Department department = new Department("Computer Science");
        Student student = new Student("Alice", Gender.FEMALE, address, department);
        Course course = new Course("Programming 101", 4, "Computer Science");
        course.getRegisteredStudents().add(student);
        course.addAssignment("Assignment 1", 20, 100);
        course.getAssignments().get(0).getScores().set(0, 90.0);
        assertEquals(90.0, course.calcStudentAvg(student));
    }
    @Test
    public void testCalcStudentAvg2() {
        Address address = new Address(123, "Main St", "Anytown", "State", "12345", "Country");
        Department department = new Department("Computer Science");
        Student student = new Student("Alice", Gender.FEMALE, address, department);
        Course course = new Course("Programming 101", 4, "Computer Science");
        course.getRegisteredStudents().add(student);
        assertEquals(0.0, course.calcStudentAvg(student));
    }
}
