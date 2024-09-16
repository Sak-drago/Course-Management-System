import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student extends User {
    private static List<Course> courses = new ArrayList<>();
    public String email;
    public String password;
    private Map<Course, Integer> course_grades;
    private int credits;
    private static int max_credits = 20;
    private String schedule;
    private String CGPA;

    public Student(String email, String password) {
        super(email, password);
        this.email = email;
        this.password = password;
    }

    public boolean s_login(){
        JOptionPane.showMessageDialog(null, "Please create or login to continue\n Choose 1 for creating a new account\n Choose 2 for login");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your choice"));
        boolean flag = false;

        if(choice == 1) {
            JOptionPane.showMessageDialog(null, "Please create a new account to continue");
            String email = JOptionPane.showInputDialog(null,"Enter your email");
            String password = JOptionPane.showInputDialog(null,"Enter your password");
            Student user = new Student(email, password);
            Students.add(user);
            JOptionPane.showMessageDialog(null, "Account created successfully\nPlease login to continue");
            String email1 = JOptionPane.showInputDialog(null,"Enter your email");
            String password1 = JOptionPane.showInputDialog(null,"Enter your password");
            for(int i =0;i<User.Students.size();i++){
                if(User.Students.get(i).email.equals(email1) && User.Students.get(i).password.equals(password1)){
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
                if(User.Students.get(i).email.equals(email) && User.Students.get(i).password.equals(password)){
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
                drop_course();
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
        String courses_list = "";
        for(int i = 0; i<courses.size();i++){
            courses_list = courses_list + "Course Code: "+CourseList.get(i).CCode+"\nCourse Name: "+CourseList.get(i).Course_name+"\nCredits: "+CourseList.get(i).Credits+"\nProfessor: "+CourseList.get(i).Professor_name+"\nEnrollment Limit: "+CourseList.get(i).enrollement_limit+"\nClass Timings: "+CourseList.get(i).class_timings;
            courses_list = courses_list + "\n======================================================================\n";
        }
        JOptionPane.showMessageDialog(null, courses_list);
    }

    public static void register_course(){
        JOptionPane.showMessageDialog(null, "Courses available for registration");
        Admin.print_course();
        String course_name = JOptionPane.showInputDialog(null,"Enter the course code for the course you want to register for");
        for(Course course : CourseList){
            if(course.CCode.equals(course_name)){
                courses.add(course);
                Course.StudentList.add(User.email);
                JOptionPane.showMessageDialog(null, "Course registered successfully");
                break;
            }
        }
    }

    public static void drop_course(){
        JOptionPane.showMessageDialog(null, "Courses registered");
        view_registered_courses();
        String course_name = JOptionPane.showInputDialog(null,"Enter the course code of the course name you want to drop");
        for(Course course : courses){
            if(course.CCode.equals(course_name)){
                courses.remove(course);
                JOptionPane.showMessageDialog(null, "Course dropped successfully");
                break;
            }
        }
    }
}
