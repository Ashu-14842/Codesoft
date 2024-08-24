package codesoft;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of subjects
        System.out.print("Enter the total number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        if (numberOfSubjects <= 0) {
            System.out.println("Please enter a valid number of subjects!");
            return;
        }

        int totalMarks = 0;
        final int maxMarksPerSubject = 100;

        // Loop to input marks for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter the marks obtained (out of 100) in subject " + i + ": ");
            int subjectMarks = scanner.nextInt();

            // Validate the input marks
            if (subjectMarks < 0 || subjectMarks > maxMarksPerSubject) {
                System.out.println("Please enter valid marks between 0 and 100!");
                i--;  // Reiterate the current subject
                continue;
            }
            totalMarks += subjectMarks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        String grade;

        // Determine the grade based on the average percentage
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B+";
        } else if (averagePercentage >= 60) {
            grade = "B";
        } else if (averagePercentage >= 50) {
            grade = "C+";
        } else if (averagePercentage >= 40) {
            grade = "C";
        } else {
            grade = "F";
        }

        // Display the results
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
