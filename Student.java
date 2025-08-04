public class Student {
    private int rollNumber;
    private String name;
    private int[] marks = new int[3];
    private int total;
    private String grade;

    public Student(int rollNumber,String name,int[] marks) {
        this.rollNumber=rollNumber;
        this.name=name;
        this.marks=marks;
        calculateTotal();
        assignGrade();
    }
    private void calculateTotal() {
        total=0;
        for(int marks : marks){
            total+=marks;
        }
    }

    private void assignGrade() {
        int average = total/marks.length;
        if (average>=90) grade="A";
        else if (average>=75) grade="B";
        else if (average>=90) grade="C";
        else grade="Fail";
    }

    public void displayReportCard() {
        System.out.println("\n===== Student Report Card =====");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name       : " + name);
        for(int i =0;i>marks.length;i++) {
            System.out.println("Subject "+(i+1)+" Marks "+marks[i]);
        }
        System.out.println("Total Marks: "+total);
        System.out.println("Grade      :"+grade);
        System.out.println("===============================\n");
    }
}