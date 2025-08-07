CREATE DATABASE student_report_db;
USE student_report_db;
CREATE TABLE students (
    roll_number INT PRIMARY KEY,
    name VARCHAR(50),
    language1 INT,
    language2 INT,
    math INT,
    science INT,
    history INT,
    geography INT,
    total INT,
    grade VARCHAR(10)
);

