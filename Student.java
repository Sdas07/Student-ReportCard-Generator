public class Student {
    private int rollNumber;
    private String name;
    private int language1;
    private int language2;
    private int math;
    private int science;
    private int history;
    private int geography;
    private int total;
    private String grade;

    // Constructor
    public Student(int rollNumber, String name, int language1, int language2, int math, int science, int history, int geography) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.language1 = language1;
        this.language2 = language2;
        this.math = math;
        this.science = science;
        this.history = history;
        this.geography = geography;
        calculateTotal();
        assignGrade();
    }

    // Getters
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getLanguage1() {
        return language1;
    }

    public int getLanguage2() {
        return language2;
    }

    public int getMath() {
        return math;
    }

    public int getScience() {
        return science;
    }

    public int getHistory() {
        return history;
    }

    public int getGeography() {
        return geography;
    }

    public int getTotal() {
        return total;
    }

    public String getGrade() {
        return grade;
    }

    // Total calculation
    private void calculateTotal() {
        total = language1 + language2 + math + science + history + geography;
    }

    // Grade assignment
    private void assignGrade() {
        int average = total / 6;
        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 60) grade = "C";
        else grade = "Fail";
    }

    // Display
    public void displayReportCard() {
        System.out.println("\n===== Student Report Card =====");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name       : " + name);
        System.out.println("Language 1 : " + language1);
        System.out.println("Language 2 : " + language2);
        System.out.println("Math       : " + math);
        System.out.println("Science    : " + science);
        System.out.println("History    : " + history);
        System.out.println("Geography  : " + geography);
        System.out.println("Total Marks: " + total);
        System.out.println("Grade      : " + grade);
        System.out.println("===============================\n");
    }
}
