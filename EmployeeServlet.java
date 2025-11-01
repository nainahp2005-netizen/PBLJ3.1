package com.portal;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String empId = req.getParameter("empId");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps;
            if (empId != null && !empId.isEmpty()) {
                ps = con.prepareStatement("SELECT * FROM employees WHERE emp_id=?");
                ps.setInt(1, Integer.parseInt(empId));
            } else {
                ps = con.prepareStatement("SELECT * FROM employees");
            }
            ResultSet rs = ps.executeQuery();

            out.println("<html><body>");
            out.println("<h2>Employee Records</h2>");
            out.println("<form method='get' action='EmployeeServlet'>");
            out.println("Search by ID: <input type='text' name='empId'/>");
            out.println("<input type='submit' value='Search'/></form><br>");

            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt(1) + "</td><td>"
                        + rs.getString(2) + "</td><td>"
                        + rs.getDouble(3) + "</td></tr>");
            }
            out.println("</table>");
            out.println("<br><a href='attendance.jsp'>Go to Attendance Portal</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
