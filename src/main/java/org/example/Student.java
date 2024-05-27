package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.util.Util;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId;

    public boolean registerCourse(Course course) {
        // Check if the course is already registered
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        // Append null for the scores of each assignment of the course
//        for (Assignment assignment : course.getAssignments()) {
//            int[] scores = assignment.getScores();
//            int[] newScores = new int[scores.length + 1];
//            System.arraycopy(scores, 0, newScores, 0, scores.length);
//            newScores[scores.length] = -1; // Using -1 to represent null scores
//            assignment.setScores(newScores);
//        }

        return true;
    }
    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.getRegisteredStudents().remove(this);
            return true;
        } else {
            return false;
        }
    }
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.studentId = String.format("S%06d", nextId);
        this.registeredCourses = new ArrayList<>();
    }
    public String toSimplifiedString(Student student) { // call this method in the Course toString
        return String.format("%s, %s, %s", student.studentId, student.studentName, student.department.getDepartmentName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses"/*here is not complete*/ +
                '}';
    }
}
/*
toString // converts a student to a string that contains the studentId, the studentName,
    the gender, the address and the department, and the registeredCourses (only the courseId, the courseName, and the departmentName)

 */