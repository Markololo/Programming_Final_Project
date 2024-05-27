package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

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
    private static int nextId;

    /**
     * adds a new assignment to the course and returns true if the assignment is added. If the assignment already
     * exists it does not add it again and returns false
     * @param assignmentName name of the cours's assignment
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
        Assignment assignment = new Assignment(assignmentName, weight, maxScore, studentAmount);
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
        assignments.add(null);
        finalScores.add(null);
        return true;
    }

    /**
     * calculates the weighted average score of a student
     * @return the weighted average score of a student
     */
    public int[] calcStudentAvg() {
        int[] weightedAvg = new int[];

        return weightedAvg;
    }
}
/*
int[] calcStudentsAverage() // calculates the weighted average score of a student.

void generateScores() // generates random scores for each assignment and student, and calculates the final score for each student.

void displayScores() // displays the scores of a course in a table, with the assignment averages and student weighted average

  example:
  Course: Programming 1(C-D00-01)
                    Assignment01   Assignment02   Assignment03         Exam01         Exam02    Final Score
          Yi Wang             82             82             76             85             80             82
          Yi Wang             97             92             84             67             90             83
          Yi Wang             91             68             82             83             83             82

          Average             90             81             81             78             84
String toSimplifiedString() // converts a course to a simple string with only the courseId, courseName, credits, and departmentName.

String toString() // converts a course to a string that contains the courseId, the courseName, the credits, the departmentName the assignments, and the registeredStudents (only the studentId, the studentName and the departmentName)

equals

getter

setter
 */