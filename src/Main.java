import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Course Management System");
        Admin.initaliseAccs();
        Student.initaliseAccs();
        Professor.initaliseAccs();
        TeachingAssistant.initaliseAccs();
        User.initialisecourse();
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Choose the type of user", "CMS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Student", "TA", "Professor", "Admin", "Exit"}, null);
            if (choice == 0) {
                Student student = s_login();
                if(student == null){
                    JOptionPane.showMessageDialog(null,"Login not found");
                    JOptionPane.showMessageDialog(null,"Restarting CMS");
                    break;
                }
                Student.studentMenu(student);
            }
            else if (choice == 1) {
                TeachingAssistant ta = ta_login();
                if(ta == null){
                    JOptionPane.showMessageDialog(null,"Login not found");
                    JOptionPane.showMessageDialog(null,"Restarting CMS");
                    break;
                }
                TeachingAssistant.teachingAssistantMenu(ta);
            }
            else if (choice == 2) {
                Professor professor = p_login();
                if(professor == null){
                    JOptionPane.showMessageDialog(null,"Login not found");
                    JOptionPane.showMessageDialog(null,"Restarting CMS");
                    break;
                }
                Professor.professorMenu(professor);
            }
            else if (choice == 3) {
                Admin admin = a_login();
                if(admin == null){
                    JOptionPane.showMessageDialog(null,"Login not found");
                    JOptionPane.showMessageDialog(null,"Restarting CMS");
                    break;
                }
                Admin.adminMenu(admin);
            }
            else if (choice == 4) {
                break;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
    }

    public static Student s_login() {
        JOptionPane.showMessageDialog(null, "Please create or login to continue\n Choose 1 for creating a new account\n Choose 2 for login");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
        boolean flag = false;

        if (choice == 1) {
            JOptionPane.showMessageDialog(null, "Please create a new account to continue");
            String email = JOptionPane.showInputDialog(null, "Enter your email");
            String password = JOptionPane.showInputDialog(null, "Enter your password");
            Student user = new Student(email, password);
            User.Students.add(user);
            JOptionPane.showMessageDialog(null, "Account created successfully\nPlease login to continue");
            String email1 = JOptionPane.showInputDialog(null, "Enter your email");
            String password1 = JOptionPane.showInputDialog(null, "Enter your password");
            for (int i = 0; i < User.Students.size(); i++) {
                if (User.Students.get(i).email.equals(email1) && User.Students.get(i).password.equals(password1)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    flag = true;
                    return User.Students.get(i);
                } else {
                    continue;
                }
            }
        } else if (choice == 2) {
            JOptionPane.showMessageDialog(null, "Please login to continue");
            String email = JOptionPane.showInputDialog(null, "Enter your email");
            String password = JOptionPane.showInputDialog(null, "Enter your password");
            Student user = new Student(email, password);
            for (int i = 0; i < User.Students.size(); i++) {
                if (User.Students.get(i).email.equals(email) && User.Students.get(i).password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    return User.Students.get(i);
                } else {
                    continue;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
        return null;
    }

    public static Admin a_login() {
        JOptionPane.showMessageDialog(null, "Please create or login to continue\n Choose 1 for creating a new account\n Choose 2 for login");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
        boolean flag = false;
        String superkey = "Admins";
        if (choice == 1) {
            JOptionPane.showMessageDialog(null, "Please enter the Superkey before continuing");
            String superkey1 = JOptionPane.showInputDialog(null, "Enter the Superkey");
            if (superkey1.equals(superkey)) {
                JOptionPane.showMessageDialog(null, "Superkey accepted");
            } else {
                JOptionPane.showMessageDialog(null, "Superkey not accepted");
                return null;
            }
            JOptionPane.showMessageDialog(null, "Please create a new account to continue");
            String email = JOptionPane.showInputDialog(null, "Enter your email");
            String password = JOptionPane.showInputDialog(null, "Enter your password");
            JOptionPane.showMessageDialog(null, "Account created successfully\nPlease login to continue");
            String email1 = JOptionPane.showInputDialog(null, "Enter your email");
            String password1 = JOptionPane.showInputDialog(null, "Enter your password");
            for (int i = 0; i < User.Admins.size(); i++) {
                if (User.Admins.get(i).email.equals(email1) && User.Admins.get(i).password.equals(password1)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    flag = true;
                    return User.Admins.get(i);
                } else {
                    continue;
                }
            }
        } else if (choice == 2) {
            JOptionPane.showMessageDialog(null, "Please login to continue");
            String email = JOptionPane.showInputDialog(null, "Enter your email");
            String password = JOptionPane.showInputDialog(null, "Enter your password");
            Admin user = new Admin(email, password);
            for (int i = 0; i < User.Admins.size(); i++) {
                if (User.Admins.get(i).email.equals(email) && User.Admins.get(i).password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    return User.Admins.get(i);
                } else {
                    continue;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
        return null;
    }

    public static TeachingAssistant ta_login() {
        boolean flag = false;
        JOptionPane.showMessageDialog(null, "Please login to continue");
        String email = JOptionPane.showInputDialog(null, "Enter your email");
        String password = JOptionPane.showInputDialog(null, "Enter your password");
        for (int i = 0; i < User.TeachingAssistants.size(); i++) {
            if (User.TeachingAssistants.get(i).email.equals(email) && User.TeachingAssistants.get(i).password.equals(password)) {
                JOptionPane.showMessageDialog(null, "Login successful");
                flag = true;
                return User.TeachingAssistants.get(i);
            }
        }

        if (!flag) {
            JOptionPane.showMessageDialog(null, "Account Not Found");
        }
        return null;
    }
        public static Professor p_login() {
        JOptionPane.showMessageDialog(null, "Please create or login to continue\n Choose 1 for creating a new account\n Choose 2 for login");
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
        boolean flag = false;
        String superkey = "Professors";
        if (choice == 1) {
            JOptionPane.showMessageDialog(null, "Please enter the Superkey before continuing");
            String superkey1 = JOptionPane.showInputDialog(null, "Enter the Superkey");
            if (superkey1.equals(superkey)) {
                JOptionPane.showMessageDialog(null, "Superkey accepted");
            } else {
                JOptionPane.showMessageDialog(null, "Superkey not accepted");
                return null;
            }
            String email = JOptionPane.showInputDialog(null, "Enter your email");
            String password = JOptionPane.showInputDialog(null, "Enter your password");
            Professor user = new Professor(email, password, "");
            User.Professors.add(user);
            JOptionPane.showMessageDialog(null, "Account created successfully\nPlease login to continue");
            String email1 = JOptionPane.showInputDialog(null, "Enter your email");
            String password1 = JOptionPane.showInputDialog(null, "Enter your password");
            for (int i = 0; i < User.Professors.size(); i++) {
                if (User.Professors.get(i).email.equals(email) && User.Professors.get(i).password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    flag = true;
                    return User.Professors.get(i);
                } else {
                    continue;
                }
            }
        } else if (choice == 2) {
            JOptionPane.showMessageDialog(null, "Please login to continue");
            String email = JOptionPane.showInputDialog(null, "Enter your email");
            String password = JOptionPane.showInputDialog(null, "Enter your password");
            Professor user = new Professor(email, password,"");
            for (int i = 0; i < User.Professors.size(); i++) {
                if (User.Professors.get(i).email.equals(email) && User.Professors.get(i).password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    flag = true;
                    return User.Professors.get(i);
                } else {
                    continue;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
        return null;
    }
}