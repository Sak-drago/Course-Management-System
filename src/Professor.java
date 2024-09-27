import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Professor extends User {
    private String Professor_name;
    public String email;
    public String password;
    public String Course_name;
    public String CourseCode;
    private String class_timings;

    public Professor(String email, String password, String CourseCode) {
        super(email, password);
        this.email = email;
        this.password = password;
        this.CourseCode = CourseCode;
    }



    public static void professorMenu(Professor professor) {
        while (true) {
            JOptionPane.showMessageDialog(null, "Please select an option\n (1)Edit Course\n (2)View Student List of a Course\n (3)View Feedback\n (4)Logout");
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
            if (choice == 1) {
                professor.edit_course();
            } else if (choice == 2) {
                professor.view_student_list_course();
            } else if (choice == 3) {
                professor.view_feedback();
            } else if (choice == 4) {
                JOptionPane.showMessageDialog(null, "Logout Successful");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
    }

    public void view_student_list_course() {
        String courseCode = JOptionPane.showInputDialog(null, "Enter the course code of the course you want to view the list of students");
        StringBuilder students_list = new StringBuilder("Student List\n");
        for (Course course : User.CourseList) {
            if (course.CCode.equals(courseCode)) {
                for (String student_email : course.StudentList) {
                    students_list.append("Email: ").append(student_email).append("\n");
                }
                JOptionPane.showMessageDialog(null, students_list.toString());
                break;
            }
        }
    }

    public void view_feedback(){
        String courseCode = JOptionPane.showInputDialog(null, "Enter the course code of the course you want to view the feedback of");
        for (Course course : User.CourseList) {
            if (course.CCode.equals(courseCode)) {
                StringBuilder feedback_list = new StringBuilder("Feedback List\n");
                for (Feedback<?> feedback : course.feedbackList) {
                    feedback_list.append("Student Email: ").append(feedback.getStudentEmail()).append("\nFeedback: ").append(feedback.getFeedback()).append("\n");
                }
                JOptionPane.showMessageDialog(null, feedback_list.toString());
                break;
            }
        }
    }

    public void edit_course() {
        String courseCode = JOptionPane.showInputDialog(null, "Enter the course code of the course you want to edit");
        try{
        for (Course course : User.CourseList) {
            if (course.CCode.equals(courseCode) && this.CourseCode.equals(courseCode)) {
                List<String> options = Arrays.asList("Class Timings", "Syllabus", "Credits");
                int choice = JOptionPane.showOptionDialog(null, "What do you want to update?", "Update Course",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options.toArray(), null);

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
                String courses_details = course.CCode + "\nCourse Name: " + course.Course_name + "\nCredits: " + course.Credits + "\nProfessor: " + course.Professor_name + "\nEnrollment Limit: " + course.enrollement_limit + "\nClass Timings: " + course.class_timings;
                JOptionPane.showMessageDialog(null, courses_details);
            } else {
                JOptionPane.showMessageDialog(null, "Course not found");
            }
            return;
            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Course not found");
        }
    }

    public static void initaliseAccs() {
        Professors.add(new Professor("prof1", "prof1", "DSA"));
        Professors.add(new Professor("prof2", "prof2", "CSA"));
    }
}



