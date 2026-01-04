package studregapp.servlet;

import model.Student;
import model.StudentDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;

public class ShowAllServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
            StudentDAO dao = new StudentDAO(conn);
            List<Student> students = dao.getAllStudents();

            request.setAttribute("students", students);
            RequestDispatcher rd = request.getRequestDispatcher("show_all.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error retrieving students", e);
        }
    }
}