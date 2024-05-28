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
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAvg;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    /**
     * generates random scores for all students in an assignment, the scores are generated with the following rule:
     * Firstly generate a random number in range [0, 10], then
     * if the number is 0, then generate a random score in range [0, 60) for the student
     * if the number is 1, 2, then generate a random score in range [60, 70) for the student
     * if the number is 3, 4, then generate a random score in range [70, 80) for the student
     * if the number is 5, 6, 7, 8, then generate a random score in range [80, 90) for the student
     * if the number is 9, 10, then generate a random score in range [90, 100] for the student
     */
    public void generateRandomScore() {
        Random rand = new Random();
        for (int i = 0; i < scores.size(); i++) {
            int randForScore = rand.nextInt(0, 11);
            int randScore = switch (randForScore) {
                case 0 -> rand.nextInt(0, 60);
                case 1, 2 -> rand.nextInt(60, 70);
                case 3, 4 -> rand.nextInt(70, 80);
                case 5, 6, 7, 8 -> rand.nextInt(80, 90);
                default -> rand.nextInt(90, 101);
            };
            scores.set(i, randScore);
        }
    }

    /**
     * calculates the average score for one assignment and assigns it to the assignmentAvg field
     */
    public void calcAssignmentAvg() {

        double sum = 0;
        int scoresSize = scores.size();
        for (int i = 0; i < scoresSize; i++) {
            sum += scores.get(i);
        }
        this.assignmentAvg = sum / scoresSize;
    }
    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = String.format("A%02d", nextId++);
        this.assignmentName = Util.toTitleCase(assignmentName);
        this.weight = weight;
        this.maxScore = maxScore;
        calcAssignmentAvg();
        this.scores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                "assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                '}';
    }
}
