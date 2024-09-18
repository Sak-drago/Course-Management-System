import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class User {
    public static String email;
    public static String password;
    public static String name;
    public static List<Student> Students = new ArrayList<>();
    public static List<Professor> Professors = new ArrayList<>();
    public static List<Admin> Admins = new ArrayList<>();
    public static List<Complaints> Complaints = new ArrayList<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public static void initialiseAccs() {

    }

    public static List<Course> CourseList = new ArrayList<>();
    public static void initialisecourse() {
        Course DSA = new Course("DSA", 4, "Data Structures and Algorithms", "Prof. A", 50, "10:00-11:00", new ArrayList<>());
        Course CSA = new Course("CSA", 4, "Cute Structures and Algorithms", "Prof. B", 50, "12:00-13:00", Arrays.asList("DSA"));
        Course OOP = new Course("OOP", 4, "Object Oriented Programming", "Prof. C", 50, "14:00-15:00", Arrays.asList("DSA"));
        Course DBMS = new Course("DBMS", 4, "Database Management Systems", "Prof. D", 50, "16:00-17:00", Arrays.asList("DSA", "OOP"));
        Course OS = new Course("OS", 4, "Operating Systems", "Prof. E", 50, "18:00-19:00", Arrays.asList("CSA", "OOP"));

        if (CourseList.size() == 0) {
            CourseList.add(DSA);
        }
        if (CourseList.size() == 1) {
            CourseList.add(CSA);
        }
        if (CourseList.size() == 2) {
            CourseList.add(OOP);
        }
        if (CourseList.size() == 3) {
            CourseList.add(DBMS);
        }
        if (CourseList.size() == 4) {
            CourseList.add(OS);
        }
    }
}
