import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Course Management System");
        Student student = new Student("email", "password");
        Professor professor = new Professor("email", "password", "code");
        Admin admin = new Admin("email", "password");
        Admin.initaliseAccs();
        Student.initaliseAccs();
        Professor.initaliseAccs();
        User.initialisecourse();
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Choose the type of user", "CMS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Student", "Professor", "Admin", "Exit"}, null);
            boolean flag = false;
            if (choice == 0) {
                JOptionPane.showMessageDialog(null, "Student Login");
                Student user = new Student("email", "password");
                flag = student.login();
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "Login Error");
                    JOptionPane.showMessageDialog(null, "Restart CMS to try again");
                    return;
                }

                Student.studentMenu(student);
            } else if (choice == 1) {
                JOptionPane.showMessageDialog(null, "Professor Login");
                Professor user = new Professor("email", "password", "code");
                flag = professor.login();
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "Login Error");
                    JOptionPane.showMessageDialog(null, "Restart CMS to try again");
                    return;
                }
                Professor.professorMenu(professor);
            } else if (choice == 2) {
                JOptionPane.showMessageDialog(null, "Admin Login");
                Admin user = new Admin("email", "password");
                flag = admin.login();
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "Login Error");
                    JOptionPane.showMessageDialog(null, "Restart CMS to try again");
                    return;
                }
                Admin.adminMenu(admin);
            } else if (choice == 3) {
                JOptionPane.showMessageDialog(null, "Exiting CMS");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }

        }
    }
}