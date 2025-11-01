package com.portal;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        String studentId = req.getParameter("studentId");
        String date = req.getParameter("date");
        String status = req.getParameter("status");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO attendance(student_id, date, status) VALUES (?, ?, ?)");
            ps.setString(1, studentId);
            ps.setString(2, date);
            ps.setString(3, status);
            int result = ps.executeUpdate();

            if (result > 0)
                out.println("<h3>Attendance Recorded Successfully!</h3>");
            else
                out.println("<h3>Error Recording Attendance</h3>");

            out.println("<a href='attendance.jsp'>Back</a>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
