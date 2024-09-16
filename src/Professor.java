import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Professor extends User {
    private String Professor_name;
    public String email;
    public String password;
    public String Course_name;
    public static String CourseCode;
    private String class_timings;

    public Professor(String email, String password, String CourseCode) {
        super(email, password);
        this.email = email;
        this.password = password;
        Professor.CourseCode = CourseCode;
    }

    public boolean p_login() {
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
                return false;
            }
            JOptionPane.showMessageDialog(null, "Please create a new account to continue");
            String email = JOptionPane.showInputDialog(null, "Enter your email");
            String password = JOptionPane.showInputDialog(null, "Enter your password");
            Professor user = new Professor(email, password, "");
            Professors.add(user);
            JOptionPane.showMessageDialog(null, "Account created successfully\nPlease login to continue");
            String email1 = JOptionPane.showInputDialog(null, "Enter your email");
            String password1 = JOptionPane.showInputDialog(null, "Enter your password");
            for (int i = 0; i < User.Professors.size(); i++) {
                if (User.Professors.get(i).email.equals(email) && User.Professors.get(i).password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    flag = true;
                    break;
                } else {
                    continue;
                }
            }
        } else if (choice == 2) {
            JOptionPane.showMessageDialog(null, "Please login to continue");
            String email = JOptionPane.showInputDialog(null, "Enter your email");
            String password = JOptionPane.showInputDialog(null, "Enter your password");
            User user = new User(email, password);
            for (int i = 0; i < User.Professors.size(); i++) {
                if (User.Professors.get(i).email.equals(email) && User.Professors.get(i).password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    flag = true;
                    break;
                } else {
                    continue;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
        return flag;
    }

    public static void professorMenu(Professor professor) {
        while (true) {
            JOptionPane.showMessageDialog(null, "Please select an option\n (1)Edit Course\n (2)View Student List of a Course\n (3)Logout");
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
            if (choice == 1) {
                edit_course();
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

    public static void view_student_list_course() {
        String courseCode = JOptionPane.showInputDialog(null, "Enter the course code of the course you want to view the list of students");
        StringBuilder students_list = new StringBuilder("Student List\n");
        for (Course course : User.CourseList) {
            if (course.CCode.equals(courseCode)) {
                for (String student_email : Course.StudentList) {
                    students_list.append("Email: ").append(student_email).append("\n");
                }
                JOptionPane.showMessageDialog(null, students_list.toString());
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Course Code Mismatch " + course.CCode + " and " + CourseCode);
            }
        }
    }


    public static void edit_course() {
        String courseCode = JOptionPane.showInputDialog(null, "Enter the course code of the course you want to edit");
        for (Course course : User.CourseList) {
            if (course.CCode.equals(courseCode)) {
                List<String> options = Arrays.asList("Class Timings", "Syllabus", "Credits");
                int choice = JOptionPane.showOptionDialog(null, "What do you want to update?", "Update Course",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options.toArray(), options.get(0));

                switch (choice) {
                    case 0:
                        String newTimings = JOptionPane.showInputDialog(null, "Enter new class timings");
                        course.class_timings = newTimings;
                        break;
                    case 1:
                        String newSyllabus = JOptionPane.showInputDialog(null, "Enter new syllabus");
                        course.Syllabus = newSyllabus;
                        break;
                    case 2:
                        int newCredits = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter new credits"));
                        course.Credits = newCredits;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice");
                        return;
                }

                JOptionPane.showMessageDialog(null, "Course details updated successfully");
                String courses_details= course.CCode+"\nCourse Name: "+course.Course_name+"\nCredits: "+course.Credits+"\nProfessor: "+course.Professor_name+"\nEnrollment Limit: "+course.enrollement_limit+"\nClass Timings: "+course.class_timings;
                JOptionPane.showMessageDialog(null, courses_details);
                }

            else {
                JOptionPane.showMessageDialog(null, "Course not found");
            }
                return;

        }
    }
}



