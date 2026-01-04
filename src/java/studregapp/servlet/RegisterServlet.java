package studregapp.servlet;

// Your model classes
import model.Student;
import model.StudentDAO;
// Standard Java libraries
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Jakarta Servlet API
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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