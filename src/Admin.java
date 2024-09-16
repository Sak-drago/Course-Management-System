import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User{
    private String Admin_name;
    public static String email;
    public static String password;

    public Admin(String email, String password) {
        super(email, password);
        this.email = email;
        this.password = password;
    }

    public static void print_course(){
        System.out.println("Course List called: " +CourseList.size());
        String courses_list = "";
        for(int i = 0; i<CourseList.size();i++){
            courses_list = courses_list + "Course Code: "+CourseList.get(i).CCode+"\nCourse Name: "+CourseList.get(i).Course_name+"\nCredits: "+CourseList.get(i).Credits+"\nProfessor: "+CourseList.get(i).Professor_name+"\nEnrollment Limit: "+CourseList.get(i).enrollement_limit+"\nClass Timings: "+CourseList.get(i).class_timings;
            courses_list = courses_list + "\n======================================================================\n";
        }
        JOptionPane.showMessageDialog(null, courses_list);
    }


    public boolean a_login(){
        JOptionPane.showMessageDialog(null, "Please create or login to continue\n Choose 1 for creating a new account\n Choose 2 for login");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your choice"));
        boolean flag = false;
        String superkey = "Admins";
        if(choice == 1) {
            JOptionPane.showMessageDialog(null, "Please enter the Superkey before continuing");
            String superkey1 = JOptionPane.showInputDialog(null,"Enter the Superkey");
            if(superkey1.equals(superkey)){
                JOptionPane.showMessageDialog(null, "Superkey accepted");
            }
            else {
                JOptionPane.showMessageDialog(null, "Superkey not accepted");
                return false;
            }
            JOptionPane.showMessageDialog(null, "Please create a new account to continue");
            String email = JOptionPane.showInputDialog(null,"Enter your email");
            String password = JOptionPane.showInputDialog(null,"Enter your password");
            //Admin user = new User(email, password);
            //User.Professors.put(email, password);
            JOptionPane.showMessageDialog(null, "Account created successfully\nPlease login to continue");
            String email1 = JOptionPane.showInputDialog(null,"Enter your email");
            String password1 = JOptionPane.showInputDialog(null,"Enter your password");
            for(int i =0;i<User.Professors.size();i++){
                if(Admins.get(i).email.equals(email1) && Admins.get(i).password.equals(password1)){
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
            for(int i =0;i<User.Professors.size();i++){
                if(Admins.get(i).email.equals(email) && Admins.get(i).password.equals(password)){
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
}

