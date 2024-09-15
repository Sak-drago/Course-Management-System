import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Course Management System");
        JOptionPane.showMessageDialog(null, "Please select if you are\n (1)Student\n (2)Professor\n (3)Admin");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your choice"));
        boolean flag = false;
        String type;
        if(choice == 1) {
            JOptionPane.showMessageDialog(null, "You are a student");
            Student student = new Student();
            flag = student.s_login();
            type = "Student";
        }
        else if(choice == 2) {
            JOptionPane.showMessageDialog(null, "You are a Professor");
            Professor professor = new Professor();
            flag = professor.p_login();
            type = "Professor";
        }
        else if(choice == 3) {
            JOptionPane.showMessageDialog(null, "You are an Admin");
            Admin admin = new Admin();
            flag = admin.a_login();
            type = "Admin";
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }


        if(!flag) {
            JOptionPane.showMessageDialog(null, "Login Error");
            JOptionPane.showMessageDialog(null, "Restart ERP to try again");
            return;
        }


    }
}
