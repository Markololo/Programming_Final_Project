package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;

    /**
     * adds a new assignment to the course and returns true if the assignment is added. If the assignment already
     * exists it does not add it again and returns false
     * @param assignmentName name of the course's assignment
     * @param weight weight of the assignment
     * @param maxScore maximum
     * @return true if assignment is added successfully
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        // Check if the assignment already exists
        for (Assignment assignment : assignments) {
            if (assignment.getAssignmentName().equals(assignmentName)) {
                return false;
            }
        }
        // Add the new assignment
        int studentAmount = registeredStudents.size();
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);
        assignments.add(assignment);
        return true;
    }

    /**
     * checks if the sum of weights of all assignments of that course equals to 1 (100%)
     * @return true if the sum of weights of the course's assignments is 1
     */
    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 1;

    }

    /**
     *adds a student to the student list of the course, adds a new null element
     * to each assignment of this course, and adds a new null element for the finalScores. Returns whether the
     * student was registered successfully
     * @param student the student input
     * @return false if it cannot register the student since he is already registered
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);

        for (int i = 0; i < assignments.size(); i++) {
            assignments.get(i).getScores().add(null);
        }

        finalScores.add(null);
        return true;
    }

    /**
     * calculates the weighted average score of a student
     * @return the weighted average score of a student
     */
    public int[] calcStudentAvg() {
//        int [] sums = new int[registeredStudents.size()];
//        for (int i = 0; i < registeredStudents.size(); i++) {
//            double sum = 0;
//            for (Assignment assignment: assignments) {
//                sum += assignment.getScores().get(i);
//            }
//            sums[i] = (int) (sum / assignments.size());
//        }
//        return sums;
        int[] weightedAvg = new int[assignments.size()];

        for (Assignment assignment: assignments){
            for (int i = 0; i < assignments.size(); i++) {
               // weightedAvg[i] = assignment.getWeight() * ;
            }
        }
        return weightedAvg;
    }

    /**
     * generates random scores for each assignment and student, and calculates the final score for each student
     */
    public void generateScores() {
        Random rand = new Random();
        for (Assignment assignment: assignments) {
            for (int i = 0; i < registeredStudents.size(); i++) {
                double randomScore = rand.nextDouble(0, 101);
                assignment.getScores().set(i, randomScore);
            }
        }
    }

    /**
     * displays the scores of a course in a table, with the assignment averages and student weighted average
     */
    public void displayScores() {
        for (Assignment assignment : assignments) {
            System.out.println("Assignment: " + assignment.getAssignmentName());
            ArrayList<Double> scores = assignment.getScores();
            for (int i = 0; i < scores.size(); i++) {
                Student student = registeredStudents.get(i);
                System.out.println("Student: " + student.getStudentId() + " " + student.getStudentName() + ", Score: " + (scores.get(i) == -1 ? "Not graded" : scores.get(i)));
            }
            System.out.println();
        }
    }

    /**
     * converts a course to a simple string with only the courseId, courseName, credits, and departmentName
     * @return the simplified string containing the course's name, id, credits and department name
     */
    public String toSimplifiedString() {
        return String.format("CourseId: %s, CourseName: %s, Credits: %d, DepartmentName: %s",
                courseId, courseName, credits, department.getDepartmentName());
    }
    public Course(String courseId, String courseName, double credits, Department department, ArrayList<Assignment> assignments,
                  ArrayList<Student> registeredStudents, ArrayList<Double> finalScores) {
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * converts a course to a string that contains the courseId, the courseName, the credits,
     * the departmentName the assignments, and the registeredStudents (only the studentId, the studentName and the departmentName)
     * @return a string representing the course
     */
    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                ", assignments=" + assignments +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
