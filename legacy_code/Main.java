// [DEPRECATED] This file was part of the earlier console-based version.
// Replaced by StudentReportGUI.java in the final version.


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        // Create student object
        Student student = new Student(roll, name, marks);

        // Display report
        student.displayReportCard();

        // Save to DB
        StudentDB.insertStudent(student);

        sc.close();
    }
}
