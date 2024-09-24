import javax.swing.*;

public class TeachingAssistant extends Student {
    public String email;
    public String password;
    public String TACCode;

    public TeachingAssistant(String email, String password, String CourseCode) {
        super(email, password);
        this.email = email;
        this.password = password;
        this.TACCode = CourseCode;
    }



    public static void teachingAssistantMenu(TeachingAssistant teachingAssistant) {
        JOptionPane.showMessageDialog(null, "Welcome Teaching Assistant");
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Choose which Menu to access", "CMS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Student Menu", "TA Menu", "Exit"}, null);
            if (choice == 0) {
                Student.studentMenu(teachingAssistant);
            } else if (choice == 1) {
                teachingAssistant.teachingAssistantOptions();
            } else if (choice == 2) {
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
    }

    public void teachingAssistantOptions() {
        int choice = JOptionPane.showOptionDialog(null, "Choose the action you want to perform", "CMS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"View Student List", "Grade Student", "Exit"}, null);
        if (choice == 0) {
            for (Course course : User.CourseList) {
                if (course.CCode.equals(this.TACCode)) {
                    StringBuilder students_list = new StringBuilder("Student List\n");
                    for (String student_email : course.StudentList) {
                        students_list.append("Email: ").append(student_email).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, students_list.toString());
                    break;
                }
            }
        } else if (choice == 1) {
            String studentEmail = JOptionPane.showInputDialog(null, "Enter the email of the student you want to grade");
            String grade = JOptionPane.showInputDialog(null, "Enter the grade of the student");
            for (Student student : User.Students) {
                if (student.email.equals(studentEmail)) {
                    for (Course course : student.courses) {
                        if (course.CCode.equals(this.TACCode)) {
                            course.Course_grade = grade;
                            JOptionPane.showMessageDialog(null, "Grade updated successfully");
                            return;
                        }
                    }
                }
            }
        } else if (choice == 2) {
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
    }

    public static void initaliseAccs() {
        User.TeachingAssistants.add(new TeachingAssistant("ta", "ta", "DSA"));
    }
}
