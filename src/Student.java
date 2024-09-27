import javax.swing.*;
import java.util.*;

public class Student extends User {
    public List<Course> courses = new ArrayList<>();
    public List<Course> completed_courses = new ArrayList<>();
    public String email;
    public String password;
    public String student_name;
    public int Credits;
    private static int max_credits = 20;
    private String schedule;
    private String CurrentSemester;
    String CGPA;
    public List<Feedback<?>> feedbackList = new ArrayList<>();

    public Student(String email, String password) {
        super(email, password);
        this.email = email;
        this.password = password;
    }

    public static void studentMenu(Student student) {
        JOptionPane.showMessageDialog(null, "Welcome Student");
        while (true) {
            JOptionPane.showMessageDialog(null, "Please select if you want to\n (1) View Courses\n (2) View Grades\n (3) Register for a course\n (4) Drop a course\n (5) View Schedule\n (6) Complaint Portal\n (7) Feedback Portal\n (8) Logout");
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
            if (option == 1) {
                student.view_registered_courses();
            } else if (option == 2) {
                student.view_grades();
            } else if (option == 3) {
                student.register_course();
            } else if (option == 4) {
                student.drop_course();
            } else if (option == 5) {
                student.view_schedule();
            } else if (option == 6) {
                student.submit_complaint();
            } else if (option == 7) {
                student.feedbackMenu();
            } else if (option == 8) {
                JOptionPane.showMessageDialog(null, "Logout successful");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
    }

    public static int getMax_credits() {
        return max_credits;
    }

    public static void setMax_credits(int max_credits) {
        Student.max_credits = max_credits;
    }

    public void view_registered_courses() {
        String courses_list = "";
        try {
            for (int i = 0; i < this.courses.size(); i++) {
                courses_list = courses_list + "Course Code: " + CourseList.get(i).CCode + "\nCourse Name: " + CourseList.get(i).Course_name + "\nCredits: " + CourseList.get(i).Credits + "\nProfessor: " + CourseList.get(i).Professor_name + "\nEnrollment Limit: " + CourseList.get(i).enrollement_limit + "\nClass Timings: " + CourseList.get(i).class_timings;
                courses_list = courses_list + "\n======================================================================\n";
            }
            JOptionPane.showMessageDialog(null, courses_list, "Courses", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No courses registered");
        }
    }

    public void register_course() {
        JOptionPane.showMessageDialog(null, "Courses available for registration");
        Admin.print_course();
        String course_name = JOptionPane.showInputDialog(null, "Enter the course code for the course you want to register for");
        for (Course course : CourseList) {
            if (course.CCode.equals(course_name)) {
                boolean prerequisitesMet = true;
                for (String prerequisite : course.preRequisites) {
                    boolean hasPrerequisite = false;
                    for (Course completedCourse : completed_courses) {
                        if (completedCourse.CCode.equals(prerequisite)) {
                            hasPrerequisite = true;
                            break;
                        }
                    }
                    if (!hasPrerequisite) {
                        prerequisitesMet = false;
                        break;
                    }
                }
                if (prerequisitesMet) {
                    if (this.Credits < 20 && course.Credits + this.Credits <= 20) {
                        courses.add(course);
                        course.StudentList.add(this.email);
                        this.Credits += course.Credits;
                    } else {
                        JOptionPane.showMessageDialog(null, "You have exceeded the maximum credit limit");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "You do not meet the prerequisites for this course");
                }
                break;
            }
        }
    }

    public void drop_course() {
        view_registered_courses();
        String course_name = JOptionPane.showInputDialog(null, "Enter the course code of the course name you want to drop");
        for (Course course : this.courses) {
            if (course.CCode.equals(course_name)) {
                courses.remove(course);
                course.StudentList.remove(User.email);
                JOptionPane.showMessageDialog(null, "Course dropped successfully");
                break;
            }
        }
    }

    public void view_grades() {
        String stringmaker = "";
        for (int i = 0; i < courses.size(); i++) {
            stringmaker += "Course Code: " + courses.get(i).CCode + "\nCourse Name: " + courses.get(i).Course_name + "\nGrade: " + courses.get(i).Course_grade;
            stringmaker += "\n======================================================================\n";
        }
        stringmaker += "CGPA: " + this.CGPA;
        JOptionPane.showMessageDialog(null, stringmaker);
    }

    public void view_schedule() {
        String stringmaker = "";
        for (int i = 0; i < this.courses.size(); i++) {
            stringmaker += "Course Code: " + this.courses.get(i).CCode + " => Class Timings: " + this.courses.get(i).class_timings;
            stringmaker += "\n======================================================================\n";
        }
        JOptionPane.showMessageDialog(null, stringmaker);
    }

    public void submit_complaint() {
        List<String> options = Arrays.asList("Submit Complaint", "View Status", "Exit");
        int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Complaint Box", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options.toArray(), null);
        if (choice == 0) {
            String complaint = JOptionPane.showInputDialog(null, "Enter your complaint");
            Complaints.add(new Complaints(Complaints.size() + 1, complaint, User.email));
            JOptionPane.showMessageDialog(null, "Complaint submitted successfully");
        } else if (choice == 1) {
            String stringmaker = "";
            for (int i = 0; i < Complaints.size(); i++) {
                if (Complaints.get(i).person.equals(User.email)) {
                    stringmaker += "Complaint ID: " + Complaints.get(i).Complaint_Code + "\nComplaint: " + Complaints.get(i).Complaint + "\nStatus: " + Complaints.get(i).show_status;
                    stringmaker += "\n======================================================================\n";
                }
            }
            JOptionPane.showMessageDialog(null, stringmaker);
        } else if (choice == 2) {
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
    }
    public String getCurrentSemester() {
        return this.CurrentSemester;
    }

    public void feedbackMenu(){
        int choice  = JOptionPane.showOptionDialog(null, "Choose the type of feedback", "Feedback", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"View Feedback Given", "Give Feedback"}, null);
        if(choice == 0) {
            viewFeedback();
        }
        else if(choice == 1) {
            giveFeedback();
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid choice");
        }
    }

    public void viewFeedback(){
        String feedbacks = "";
        for (Feedback<?> feedback : feedbackList) {
            feedbacks += feedback.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, feedbacks);
    }
    public void giveFeedback() {
        String Code = JOptionPane.showInputDialog(null, "Enter the Course Code for feedback");
        if(completed_courses.isEmpty()){
            JOptionPane.showMessageDialog(null, "Course not Completed or does not exist");
            return;
        }
        for (Course completedCours : completed_courses) {
            if (!(Objects.equals(completedCours.CCode, Code))) {
                JOptionPane.showMessageDialog(null, "Course not Completed or does not exist");
                return;
            }
        }

        int choice = JOptionPane.showOptionDialog(null, "Choose the type of feedback", "Feedback", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Rating", "Comment"}, null);
        if (choice == 0) {
            int rating = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your rating (1-5)"));
            feedbackList.add(new Feedback<>(Code , this.email, rating));
        } else if (choice == 1) {
            String comment = JOptionPane.showInputDialog(null, "Enter your feedback");
            feedbackList.add(new Feedback<>(Code , this.email, comment));
        } else {
            JOptionPane.showMessageDialog(null, "Invalid feedback type");
        }
    }

    public void setCurrentSemester(String semester) {
        this.CurrentSemester = semester;
    }
    public static void initaliseAccs() {
        Students.add(new Student("sak", "sak"));
        Students.add(new Student("rishi", "rishi"));
        Students.add(new Student("saksham", "saksham"));
    }

}

