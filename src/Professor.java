import javax.swing.*;

public class Professor extends User {
    private String Professor_name;
    public static String email;
    public static String password;
    public String Course_name;
    public static String CourseCode;
    private String class_timings;

    public Professor(String email, String password) {
        super(email, password);
        Professor.email = email;
        Professor.password = password;
    }
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
            Professor.email = email;
            Professor.password = password;
            JOptionPane.showMessageDialog(null, "Account created successfully\nPlease login to continue");
            String email1 = JOptionPane.showInputDialog(null,"Enter your email");
            String password1 = JOptionPane.showInputDialog(null,"Enter your password");
            for(int i =0;i<User.Professors.size();i++){
                if(Professors.get(i).email.equals(email) && Professors.get(i).password.equals(password)){
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
                if(Professor.email.equals(email) && Professor.password.equals(password)){
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

    public static void professorMenu(Professor professor){
        while (true) {
            JOptionPane.showMessageDialog(null, "Please select an option\n (1)Edit Course\n (2)View Student List of a Course\n (3)Exit");
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
            if (choice == 1) {
                //edit_course();
            } else if (choice == 2) {
                view_student_list_course();
            } else if (choice == 3) {
                JOptionPane.showMessageDialog(null, "Logout Successful");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
    }

    public static void view_student_list_course(){
        for(Course course : User.CourseList){
            if(course.CourseCode.equals(Professor.CourseCode)){
                String students_list = "Student List\n";
                for (String student_name : Course.StudentList) {
                    students_list = students_list + "Email: " + student_name + "\n";
                }
                JOptionPane.showMessageDialog(null, students_list);
            }
        }
    }
}
