<%@ page import="java.util.*, model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Students</title>
</head>
<body>
    <h2>Registered Students</h2>
    <table border="1">
        <tr><th>Name</th><th>Email</th><th>Year</th></tr>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            for (Student s : students) {
        %>
            <tr>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getYear() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>