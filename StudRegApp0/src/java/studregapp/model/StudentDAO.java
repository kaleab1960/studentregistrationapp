package model;

import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, email, year) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, student.getName());
        stmt.setString(2, student.getEmail());
        stmt.setString(3, student.getYear());
        stmt.executeUpdate();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            list.add(new Student(
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("year")
            ));
        }
        return list;
    }
}