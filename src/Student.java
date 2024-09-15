import javax.swing.*;
import java.util.List;
import java.util.Map;

public class Student extends User {
    private List<Course> courses;
    private Map<Course, Integer> course_grades;
    private int credits;
    private int max_credits = 20;


    public boolean login(){
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
}
