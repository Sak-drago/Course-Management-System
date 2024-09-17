import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    public static String email;
    public static String password;
    public static List<Student> Students = new ArrayList<>();
    public static List<Professor> Professors = new ArrayList<>();
    public static List<Admin> Admins = new ArrayList<>();
    public static List<Complaints> Complaints = new ArrayList<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public static void initialiseProf() {
        Professors.add(new Professor("sak", "sak", "DSA"));
        Professors.add(new Professor("prof2", "prof2", "CSA"));
        Professors.add(new Professor("prof3", "prof3", ""));
        Admins.add(new Admin("admin", "admin"));
        Students.add(new Student("sak","sak"));
    }

    public static List<Course> CourseList = new ArrayList<>();
    public User() {
        initialiseProf();
        Course DSA = new Course("DSA", 4, "Data Structures and Algorithms", "Prof. A", 50, "10:00-11:00");
        if(CourseList.size() == 0) {
            CourseList.add(DSA);
        }
        if(CourseList.size()==1) {
            Course CSA = new Course("CSA", 4, "Cute Structures and Algorithms", "Prof. B", 50, "12:00-13:00");
            CourseList.add(CSA);
        }
    }


}
