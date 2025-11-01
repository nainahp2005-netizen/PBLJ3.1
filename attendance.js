<!DOCTYPE html>
<html>
<head><title>Attendance Form</title></head>
<body>
<h2>Student Attendance Portal</h2>
<form method="post" action="AttendanceServlet">
    Student ID: <input type="text" name="studentId"/><br>
    Date: <input type="date" name="date"/><br>
    Status:
    <select name="status">
        <option>Present</option>
        <option>Absent</option>
    </select><br>
    <input type="submit" value="Submit"/>
</form>
<br>
<a href="employee.jsp">Back to Employees</a>
</body>
</html>
