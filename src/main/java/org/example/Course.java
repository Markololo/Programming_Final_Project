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
    private double[] finalScores;
    private static int nextId;

//    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
//        int studentAmount = registeredStudents.size();
//        Assignment assignment = new Assignment(assignmentName, weight, maxScore, studentAmount);
//        assignments.add(assignment); // it should return false if we cannot add the assignment
//    }
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        // Check if the assignment already exists
        for (Assignment assignment : assignments) {
            if (assignment.getAssignmentName().equals(assignmentName)) {
                return false; // Assignment already exists
            }
        }
        // Calculate the total weight if the new assignment is added
        //double totalWeight = assignments.stream().mapToDouble(Assignment::getAssignmentWeight).sum() + weight;
//        double totalWeight = 0;
//        for(int i = 0; i < m.size(); i++)
//            totalWeight += m.get(i);
//        return totalWeight;

//        if (totalWeight > 100) {
//            return false; // Total weight exceeds 100%
//        }

        // Add the new assignment
        int studentAmount = registeredStudents.size();
        Assignment assignment = new Assignment(assignmentName, weight, maxScore, studentAmount);
        assignments.add(assignment);
        return true;
    }

    public boolean isAssignmentWeightValid() {
        int totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 100;
    }
}

//boolean isAssignmentWeightValid() // checks if the sum of weights of all assignments of that course equals to 1 (100%)
//
//boolean registerStudent(Student student) // adds a student to the student list of the course,
// also add a new null element to each assignment of this course, and add a new null element for the finalScores.
//
//int[] calcStudentsAverage() // calculates the weighted average score of a student.
//
//boolean addAssignment(String assignmentName, double weight, int maxScore) // adds a new assignment to the course
//
//void generateScores() // generates random scores for each assignment and student, and calculates the final score
// for each student.
