import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Roll Number: ");
        int roll=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        int[] marks = new int[3];
        for(int i=0;i<3;i++) {
            System.out.println("Enter marks for Subject: "+(i+1)+": ");
            marks[i]=sc.nextInt();
        }

        Student student = new Student(roll, name, marks);
        student.displayReportCard();

        sc.close();
    }
}