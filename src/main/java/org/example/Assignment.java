package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAvg;
    private ArrayList<Double> scores;
    private static int nextId;

//    public Assignment(String assignmentName, double weight, int maxScore, int studentAmount) {
//        this.assignmentName = assignmentName;
//        this.weight = weight;
//        this.maxScore = maxScore;
//        this.assignmentAvg = 0;
//        this.scores = ;
//    }

    public Assignment(String assignmentName, double weight, int maxScore, int studentAmount) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
    }

    Random rand = new Random();
    public void generateRandomScore() {
        int randForScore = rand.nextInt(0, 11);
        int score = switch (randForScore) {
            case 0 -> rand.nextInt(0, 60);
            case 1, 2 -> rand.nextInt(60, 70);
            case 3, 4 -> rand.nextInt(70, 80);
            case 5, 6, 7, 8 -> rand.nextInt(80, 90);
            default -> rand.nextInt(90, 101);
        };
    }
    public void calcAssignmentAvg() {
        double sum = 0;
        int scoresSize = scores.size();
        for (int i = 0; i < scoresSize; i++) {
            sum += scores.get(i);
        }
        assignmentAvg = sum / scoresSize;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                '}';
    }
}

//void calcAssignmentAvg() // calculates the average score for one assignment
//
//void generateRandomScore() // generates random scores for all students in an assignment,

//toString // generates a string to represent an assignment, with assignmentId, assignmentName,
// weight and maxScore
