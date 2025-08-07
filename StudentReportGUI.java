import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.io.FileWriter;
//import java.io.IOException;

public class StudentReportGUI extends JFrame {
    private JTextField rollField, nameField;
    private JTextField lang1Field, lang2Field, mathField, sciField, histField, geoField;
    private JTextArea reportArea;

    public StudentReportGUI() {
        setTitle("Student Report Card Generator");
        setSize(700, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        // ========== INPUT PANEL ==========
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row-wise input
        rollField = addInputRow(inputPanel, gbc, 0, "Roll Number:");
        nameField = addInputRow(inputPanel, gbc, 1, "Name:");
        lang1Field = addInputRow(inputPanel, gbc, 2, "Language 1:");
        lang2Field = addInputRow(inputPanel, gbc, 3, "Language 2:");
        mathField = addInputRow(inputPanel, gbc, 4, "Math:");
        sciField = addInputRow(inputPanel, gbc, 5, "Science:");
        histField = addInputRow(inputPanel, gbc, 6, "History:");
        geoField = addInputRow(inputPanel, gbc, 7, "Geography:");

        add(inputPanel, BorderLayout.NORTH);

        // ========== BUTTON PANEL ==========
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton generateBtn = new JButton("Generate Report");
        JButton exportBtn = new JButton("Export to CSV");
        JButton clearBtn = new JButton("Clear");

        buttonPanel.add(generateBtn);
        buttonPanel.add(exportBtn);
        buttonPanel.add(clearBtn);

        add(buttonPanel, BorderLayout.CENTER);

        // ========== REPORT AREA ==========
        reportArea = new JTextArea(15, 50);
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(reportArea), BorderLayout.SOUTH);

        // ========== BUTTON ACTIONS ==========

        generateBtn.addActionListener(e -> generateReport());
        exportBtn.addActionListener(e -> exportToCSV());
        clearBtn.addActionListener(e -> clearFields());

        setVisible(true);
    }

    private JTextField addInputRow(JPanel panel, GridBagConstraints gbc, int row, String labelText) {
        JLabel label = new JLabel(labelText);
        JTextField field = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);

        return field;
    }

    private void generateReport() {
        try {
            int roll = Integer.parseInt(rollField.getText());
            String name = nameField.getText();

            int l1 = Integer.parseInt(lang1Field.getText());
            int l2 = Integer.parseInt(lang2Field.getText());
            int math = Integer.parseInt(mathField.getText());
            int sci = Integer.parseInt(sciField.getText());
            int hist = Integer.parseInt(histField.getText());
            int geo = Integer.parseInt(geoField.getText());

            Student student = new Student(roll, name, l1, l2, math, sci, hist, geo);

            StringBuilder sb = new StringBuilder();
            sb.append("===== Student Report Card =====\n");
            sb.append(String.format("Roll Number : %d\n", student.getRollNumber()));
            sb.append(String.format("Name        : %s\n", student.getName()));
            sb.append(String.format("Language 1  : %d\n", student.getLanguage1()));
            sb.append(String.format("Language 2  : %d\n", student.getLanguage2()));
            sb.append(String.format("Math        : %d\n", student.getMath()));
            sb.append(String.format("Science     : %d\n", student.getScience()));
            sb.append(String.format("History     : %d\n", student.getHistory()));
            sb.append(String.format("Geography   : %d\n", student.getGeography()));
            sb.append(String.format("Total Marks : %d\n", student.getTotal()));
            sb.append(String.format("Grade       : %s\n", student.getGrade()));
            sb.append("================================");

            reportArea.setText(sb.toString());

            // Insert into DB
            StudentDB.insertStudent(student);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Please enter valid numbers in all fields.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + ex.getMessage());
        }
    }

    private void exportToCSV() {
    if (reportArea.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "⚠️ Generate report before exporting.");
        return;
    }

    try {
        int roll = Integer.parseInt(rollField.getText());
        String name = nameField.getText();
        int l1 = Integer.parseInt(lang1Field.getText());
        int l2 = Integer.parseInt(lang2Field.getText());
        int math = Integer.parseInt(mathField.getText());
        int sci = Integer.parseInt(sciField.getText());
        int hist = Integer.parseInt(histField.getText());
        int geo = Integer.parseInt(geoField.getText());

        Student student = new Student(roll, name, l1, l2, math, sci, hist, geo);

        java.io.File file = new java.io.File("student_report.csv");
        boolean isNewFile = file.createNewFile();  // returns true if file did not exist

        try (FileWriter writer = new FileWriter(file, true)) {
            if (isNewFile) {
                writer.append("Roll,Name,Lang1,Lang2,Math,Science,History,Geography,Total,Grade\n");
            }

            writer.append(student.getRollNumber() + "," +
                    student.getName() + "," +
                    student.getLanguage1() + "," +
                    student.getLanguage2() + "," +
                    student.getMath() + "," +
                    student.getScience() + "," +
                    student.getHistory() + "," +
                    student.getGeography() + "," +
                    student.getTotal() + "," +
                    student.getGrade() + "\n");
        }

        JOptionPane.showMessageDialog(this, "✅ Report exported to student_report.csv");
    
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "❌ Error writing CSV: " + ex.getMessage());
    }
}


    private void clearFields() {
        rollField.setText("");
        nameField.setText("");
        lang1Field.setText("");
        lang2Field.setText("");
        mathField.setText("");
        sciField.setText("");
        histField.setText("");
        geoField.setText("");
        reportArea.setText("");
    }

    public static void main(String[] args) {
        new StudentReportGUI();
    }
}
