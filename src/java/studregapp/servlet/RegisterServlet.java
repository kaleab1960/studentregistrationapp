package servlet;

import model.Student;
import model.StudentDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String year = request.getParameter("year");

        try {
            Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
            StudentDAO dao = new StudentDAO(conn);
            dao.insertStudent(new Student(name, email, year));

            response.sendRedirect("show_all");
        } catch (Exception e) {
            throw new ServletException("Error registering student", e);
        }
    }
}