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
