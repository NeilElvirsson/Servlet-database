package models;

import servlets.Courses;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnector {

    public static void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//PORT and DbName should be changed

            Connection con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/gritacademy",
"useruser","");
            Statement stmt = con.createStatement();
//TABLENAME should be changed

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()){

//print to console column 1 and 2

                System.out.println(rs.getInt(1) + " " + rs.getString(2));
               // System.out.println(rs.getInt(1) + " " + rs.getString(3));

            }
            con.close();
        } catch (Exception e) {
            System.out.println("Vafan");
            System.out.println(e);
        }
    }

    public static List<String> getStudentsNames() {
        List<String> studentsNames = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//PORT and DbName should be changed

            Connection con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/gritacademy",
                            "useruser", "");
            Statement stmt = con.createStatement();
//TABLENAME should be changed

            ResultSet rs = stmt.executeQuery("SELECT Fname, Lname FROM students");
            while (rs.next()) {
                String fname = rs.getString("Fname");
                String lname = rs.getString("Lname");
                studentsNames.add(fname + " " + lname);
                //studentsNames.add("Lname");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return studentsNames;

    }
    public static List<String> getCoursesNames() {
        List<String> coursesNames = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//PORT and DbName should be changed

            Connection con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/gritacademy",
                            "useruser", "");
            Statement stmt = con.createStatement();
//TABLENAME should be changed

            ResultSet rs = stmt.executeQuery("SELECT name, yhp FROM courses");
            while (rs.next()) {

                String name = rs.getString("name");
                int yhp = rs.getInt("yhp");
                String courseInfo = name + " (YHP: " + yhp + ")";
                coursesNames.add(courseInfo);
                //coursesNames.add("" + yhp);

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return coursesNames;

    }

    public static List<String> getStudentCourses() {
        List<String> studentCourses = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//PORT and DbName should be changed

            Connection con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/gritacademy",
                            "useruser", "");
            Statement stmt = con.createStatement();
//TABLENAME should be changed

            ResultSet rs = stmt.executeQuery("SELECT students.Fname, students.Lname, GROUP_CONCAT(courses.name) AS attendance FROM students INNER JOIN attendance ON students.id = attendance.student_id INNER JOIN courses ON attendance.course_id = courses.id GROUP BY students.id, students.Fname, students.Lname;");
            while (rs.next()) {
                String Fname = rs.getString("Fname");
                String Lname = rs.getString("Lname");
                String attendance = rs.getString("attendance");
                studentCourses.add(Fname + " " + Lname + ": " + attendance);
                System.out.println(studentCourses);

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return studentCourses;

    }

}
