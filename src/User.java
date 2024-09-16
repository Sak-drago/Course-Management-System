import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String email;
    String password;
    static HashMap<String, String> Students = new HashMap< String, String>();
    static Map<String, String> Professors = new HashMap<String,String>();
    static Map<String, String> Admins = new HashMap<String,String>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public static List<Course> CourseList = new ArrayList<>();
    public User() {
        Course DSA = new Course("DSA", 4, "Data Structures and Algorithms", "Prof. A", 50, "10:00-11:00");
        CourseList.add(DSA);
    }


}
