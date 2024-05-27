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
    private static int nextId = 1;

    /**
     * registers a course, this method (1) adds the course to the student's registeredCourses list, (2) adds
     * the student to the course's registeredStudents list, (3) appends a null for the scores of each assignment
     * of the course. If the course is already registered, directly returns false
     * @param course the entered course
     * @return false if the student is already in the course so can't be registered twice in the same course
     */
    public boolean registerCourse(Course course) {
        // Check if the course is already registered or is null
        if (registeredCourses.contains(course) || course == null) {
            return false;
        }
        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        //Append null for the scores of each assignment of the course
        for (Assignment assignment : course.getAssignments()) {
                assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * drops a course, remover the course from the student's registeredCourses list, and remove the student from
     * the course's registeredStudents list. If the course is not registered yet, directly returns false
     * @param course entered course
     * @return false if the course is not registered yet
     */
    public boolean dropCourse(Course course) {
        if (course == null || !registeredCourses.contains(course)) {
            return false;
        } else {
            registeredCourses.remove(course);
            course.getRegisteredStudents().remove(this);
            return true;
        }
    }

    /**
     * Constructor to create a student with studentName, gender, address, and department, it will create a student
     * with studentId automatically generated based on the nextId, and registeredCourses as empty object
     * @param studentName name of the student
     * @param gender gender of the student, either male or female
     * @param address student's address
     * @param department student's department
     */
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.studentId = String.format("S%06d", nextId);
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * converts a student to a simple string with only the studentId, the studentName,
     * and departmentName.
     * @param student the entered Student object
     * @return a simple string with only the studentId, the studentName and departmentName
     */
    public String toSimplifiedString(Student student) { // call this method in the Course toString
        return String.format("%s, %s, %s", student.studentId, student.studentName, student.department.getDepartmentName());
    }

    /**
     *  converts a student to a string that contains the studentId, the studentName, the gender, the address and the
     *  department, and the registeredCourses (only the courseId, the courseName, and the departmentName)
     * @return the string representing the student
     */
    @Override
    public String toString() {
        String coursesString = "";
        for (Course course : registeredCourses) {
            coursesString += "(" +
                    "CourseId='" + course.getCourseId() + '\'' +
                    ", CourseName='" + course.getCourseName() + '\'' +
                    ", DepartmentName='" + course.getDepartment().getDepartmentName() + '\'' +
                    "), ";
        }
        if (!coursesString.isEmpty()) {
            coursesString = coursesString.substring(0, coursesString.length() - 2); // Remove last comma and space
        }

        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=[" + coursesString + "]" +
                '}';
    }
}
