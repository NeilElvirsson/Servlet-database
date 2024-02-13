package servlets;

import models.MySQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/student-courses")
public class StudentCourses extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");

        out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: white; box-sizing: border-box; }");
        out.println("h2 { background-color: black; color: deeppink; padding: 10px; margin: 0; width: 100%; box-sizing: border-box; }");
        out.println("table { border-collapse: collapse; width: 100%; margin: 0; padding: 0; }");
        out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        out.println("th { background-color: lightgrey; color: black; }");
        out.println(".footer { position: fixed; bottom: 0; width: 100%; background-color: black; padding: 10px; text-align: center; box-sizing: border-box; }");
        out.println(".footer ul { list-style-type: none; margin: 0; padding: 0; display: flex; justify-content: space-around; }");
        out.println(".footer li { display: inline; margin-right: 15px; }");
        out.println(".footer a { text-decoration: none; color: deeppink; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Student-Courses</h2>");
        List<String> studentCourses = MySQLConnector.getStudentCourses();
        //Felsökning
        System.out.println("Retrieved student courses: " + studentCourses);

        out.println("<table>");
        out.println("<tr><th>Attendance</th></tr>");
        for (String studentCourse : studentCourses) {
            out.println("<tr><td>" + studentCourse + "</td></tr>");

        }
        out.println("</table>");

        out.println("<div class=\"footer\">");
        out.println("<ul>");
        out.println("<li>" + "<a href = http://localhost:9090/home>" + "Home" + "</a>");
        out.println("<li>" + "<a href = http://localhost:9090/students>" + "Students" + "</a>");
        out.println("<li>" + "<a href = http://localhost:9090/courses>" + "Courses" + "</a>");
        out.println("<li>" + "<a href = http://localhost:9090/student-courses>" + "Student-courses" + "</a>");
        out.println("</ul>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

}
