import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Course Management System");
        while (true) {
            JOptionPane.showMessageDialog(null, "Please select if you are\n (1)Student\n (2)Professor\n (3)Admin\n (4)Exit");
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
            boolean flag = false;
            if (choice == 1) {
                JOptionPane.showMessageDialog(null, "Student Login");
                Student student = new Student();
                flag = student.s_login();
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "Login Error");
                    JOptionPane.showMessageDialog(null, "Restart CMS to try again");
                    return;
                }

                Student.studentMenu(student);
            } else if (choice == 2) {
                JOptionPane.showMessageDialog(null, "Professor Login");
                Professor professor = new Professor();
                flag = professor.p_login();
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "Login Error");
                    JOptionPane.showMessageDialog(null, "Restart CMS to try again");
                    return;
                }
            } else if (choice == 3) {
                JOptionPane.showMessageDialog(null, "Admin Login");
                Admin admin = new Admin();
                flag = admin.a_login();
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "Login Error");
                    JOptionPane.showMessageDialog(null, "Restart CMS to try again");
                    return;
                }
            } else if (choice == 4) {
                JOptionPane.showMessageDialog(null, "Exiting CMS");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }

        }
    }
}
