package org.example;

import lombok.Getter;

@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAvg;
    private int[] scores;
    private static int nextId;

    public Assignment(String assignmentName, double weight, int maxScore, int studentAmount) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.assignmentAvg = 0;
        this.scores = scores;
    }
}

//void calcAssignmentAvg() // calculates the average score for one assignment
//
//void generateRandomScore() // generates random scores for all students in an assignment,
// the scores are generated with the following rule: Firstly generate a random number in range [0, 10], then
//
//if the number is 0, then generate a random score in range [0, 60) for the student
//if the number is 1, 2, then generate a random score in range [60, 70) for the student
//if the number is 3, 4, then generate a random score in range [70, 80) for the student
//if the number is 5, 6, 7, 8, then generate a random score in range [80, 90) for the student
//if the number is 9, 10, then generate a random score in range [90, 100] for the student
//toString // generates a string to represent an assignment, with assignmentId, assignmentName,
// weight and maxScore
