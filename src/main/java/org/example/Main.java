package org.example;

public class Main {
    // DO NOT FORGET DOCUMENTATIONS
    public static void main(String[] args) {
        Assignment assignment1 = new Assignment("assignment1", 0.5, 80);
        Assignment assignment2 = new Assignment("assignment1", 0.5, 80);

        Department department1 = new Department("CS");

        Course course = new Course("Course1", department1);
        System.out.println(course);
    }

}