import javax.swing.*;

public class Professor extends User {
    private String Professor_name;
    private String Course_name;
    private String CourseCode;
    private String class_timings;

    public boolean p_login(){
        JOptionPane.showMessageDialog(null, "Please create or login to continue\n Choose 1 for creating a new account\n Choose 2 for login");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your choice"));
        boolean flag = false;
        String superkey = "Professors";
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
            User user = new User(email, password);
            User.Professors.put(email, password);
            JOptionPane.showMessageDialog(null, "Account created successfully\nPlease login to continue");
            String email1 = JOptionPane.showInputDialog(null,"Enter your email");
            String password1 = JOptionPane.showInputDialog(null,"Enter your password");
            for(int i =0;i<User.Professors.size();i++){
                if(User.Professors.containsKey(email1) && User.Professors.containsValue(password1)){
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
                if(User.Professors.containsKey(email) && User.Professors.containsValue(password)){
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
