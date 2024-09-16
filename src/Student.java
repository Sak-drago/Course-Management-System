import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student extends User {
    private static List<Course> courses = new ArrayList<>();
    private Map<Course, Integer> course_grades;
    private int credits;
    private int max_credits = 20;
    private String schedule;
    private String CGPA;

    public boolean s_login(){
        JOptionPane.showMessageDialog(null, "Please create or login to continue\n Choose 1 for creating a new account\n Choose 2 for login");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your choice"));
        boolean flag = false;

        if(choice == 1) {
            JOptionPane.showMessageDialog(null, "Please create a new account to continue");
            String email = JOptionPane.showInputDialog(null,"Enter your email");
            String password = JOptionPane.showInputDialog(null,"Enter your password");
            User user = new User(email, password);
            User.Students.put(email, password);
            JOptionPane.showMessageDialog(null, "Account created successfully\nPlease login to continue");
            String email1 = JOptionPane.showInputDialog(null,"Enter your email");
            String password1 = JOptionPane.showInputDialog(null,"Enter your password");
            for(int i =0;i<User.Students.size();i++){
                if(User.Students.containsKey(email1) && User.Students.containsValue(password1)){
                    JOptionPane.showMessageDialog(null, "Login successful");
                    flag = true;
                    break;
                }
                else {
                    continue;
                }
            }
        }
        else if(choice == 2) {
            JOptionPane.showMessageDialog(null, "Please login to continue");
            String email = JOptionPane.showInputDialog(null,"Enter your email");
            String password = JOptionPane.showInputDialog(null,"Enter your password");
            User user = new User(email, password);
            for(int i =0;i<User.Students.size();i++){
                if(User.Students.containsKey(email) && User.Students.containsValue(password)){
                    JOptionPane.showMessageDialog(null, "Login successful");
                    flag = true;
                    break;
                }
                else {
                    continue;
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
        return flag;
    }

    public static void studentMenu(Student student){
        JOptionPane.showMessageDialog(null, "Welcome Student");
        while(true){
            JOptionPane.showMessageDialog(null, "Please select if you want to\n (1) View Courses\n (2) View Grades\n (3) Register for a course\n (4) Drop a course\n (5) View Schedule\n (6) Submit Complaint\n (7) Logout");
            int option = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your choice"));
            if(option == 1){
                view_registered_courses();
            }
            else if(option == 2){
                //view_grades();
            }
            else if(option == 3){
                register_course();
            }
            else if(option == 4){
                //student.drop_course();
            }
            else if(option == 5){
                //student.view_schedule();
            }
            else if(option == 6){
                //student.submit_complaint();
            }
            else if(option == 7){
                JOptionPane.showMessageDialog(null, "Logout successful");
                break;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
    }
    public static void view_registered_courses() {
        for (Course course : courses) {
            JOptionPane.showMessageDialog(null, course.Course_name);
        }
    }

    public static void register_course(){
        JOptionPane.showMessageDialog(null, "Courses available for registration");
        Admin.print_course();
        String course_name = JOptionPane.showInputDialog(null,"Enter the course name you want to register for");
        for(Course course : CourseList){
            if(course.CourseCode.equals(course_name)){
                courses.add(course);
                JOptionPane.showMessageDialog(null, "Course registered successfully");
                break;
            }
        }
    }
}
