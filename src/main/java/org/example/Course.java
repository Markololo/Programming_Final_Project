package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.Random;

@NoArgsConstructor
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
            if (assignment == null || assignment.getAssignmentName().equals(assignmentName)) {
                return false;
            }
        }
        // Add the new assignment
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
     * adds a student to the student list of the course, adds a new null element
     * to each assignment of this course, and adds a new null element for the finalScores. It also
     * checks whether the student was registered successfully or not.
     * @param student the student input (object of Student class)
     * @return false if it cannot register the student since he is already registered
     */
    public boolean registerStudent(Student student) {
        if (student == null || registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);

        // add a null element to each assignment of the course
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
    public int[] calcStudentsAvg() {
        int[] studentAverages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double totalWeightedScore = 0;
            for (Assignment assignment : assignments) {
                int score = assignment.getScores().get(i);
                if (score != -1) { // Only consider non-null scores
                    totalWeightedScore += score * assignment.getWeight();
                } else { // score is null
                    return null;
                }
            }
            studentAverages[i] = (int) totalWeightedScore;
        }
        return studentAverages;
    }

    /**
     * generates random scores for each assignment and student, and calculates the final score for each student
     */
    public void generateScores() {
        Random rand = new Random();

        // Generate random scores for each assignment and student
        for (Assignment assignment : assignments) {
            for (int i = 0; i < registeredStudents.size(); i++) {
                int generatedScore = rand.nextInt(0,101);
                assignment.getScores().set(i, generatedScore);
            }
        }
        // Calculate the final score for each student
        int[] studentAverages = calcStudentsAvg();
        for (int i = 0; i < finalScores.size(); i++) {
            finalScores.set(i, (double) studentAverages[i]);
        }
    }

    /**
     * displays the scores of a course in a table, with the assignment averages and student weighted average
     */
    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");

        // Print header
        System.out.print("                ");
        for (Assignment assignment : assignments) {
            System.out.print(String.format("%-15s", assignment.getAssignmentName()));
        }
        System.out.println("Final Score");

        // Print each student's scores
        for (Student student : registeredStudents) {
            System.out.print(String.format("%-15s", student.getStudentName()));
            double totalWeightedScore = 0;
            for (Assignment assignment : assignments) {
                int studentIndex = registeredStudents.indexOf(student);
                double score = assignment.getScores().get(studentIndex);
                totalWeightedScore += score * (assignment.getWeight() / 100.0);
                System.out.print(String.format("%-15s", score == -1 ? "Not graded" : score));
            }
            System.out.println(String.format("%.2f", totalWeightedScore));
        }

        // Print assignment averages
        System.out.print("Average         ");
        for (Assignment assignment : assignments) {
            double sum = 0;
            int count = 0;
            for (double score : assignment.getScores()) {
                if (score != -1) {
                    sum += score;
                    count++;
                }
            }
            double average = count == 0 ? 0 : sum / count;
            System.out.print(String.format("%-15s", average));
        }
        System.out.println();
    }


    /**
     * converts a course to a simple string with only the courseId, courseName, credits, and departmentName
     * @return the simplified string containing the course's name, id, credits and department name
     */
    public String toSimplifiedString(Course course) {
        return String.format("CourseId: %s, CourseName: %s, Credits: %d, DepartmentName: %s",
                courseId, courseName, credits, department.getDepartmentName());
    }
    public Course(String courseName, double credits, Department department) {
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
                ", departmentName=" + department.getDepartmentName() +
                ", assignments=" + assignments +
                ", registeredStudents=" + toSimplifiedString(this) +
                '}';
    }
}
