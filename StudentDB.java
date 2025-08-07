import java.sql.*;

public class StudentDB {
    public static void insertStudent(Student student) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/your_database_here", "your_username_here", "your_password_here"
            );

            String query = "INSERT INTO students (roll_number, name, language1, language2, math, science, history, geography, total, grade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, student.getRollNumber());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getLanguage1());
            stmt.setInt(4, student.getLanguage2());
            stmt.setInt(5, student.getMath());
            stmt.setInt(6, student.getScience());
            stmt.setInt(7, student.getHistory());
            stmt.setInt(8, student.getGeography());
            stmt.setInt(9, student.getTotal());
            stmt.setString(10, student.getGrade());

            stmt.executeUpdate();
            conn.close();
            System.out.println("✅ Student data inserted into the database!");

        } catch (Exception e) {
            System.out.println("❌ Error inserting student: " + e.getMessage());
        }
    }
}
