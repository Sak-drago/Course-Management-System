import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    public static String email;
    public static String password;

    public Admin(String email, String password) {
        super(email, password);
        this.email = email;
        this.password = password;
    }

    public static void print_course() {
        System.out.println("Course List called: " + CourseList.size());
        String courses_list = "";
        for (int i = 0; i < CourseList.size(); i++) {
            courses_list = courses_list + "Course Code: " + CourseList.get(i).CCode + "\nCourse Name: " + CourseList.get(i).Course_name + "\nCredits: " + CourseList.get(i).Credits + "\nProfessor: " + CourseList.get(i).Professor_name + "\nEnrollment Limit: " + CourseList.get(i).enrollement_limit + "\nClass Timings: " + CourseList.get(i).class_timings;
            courses_list = courses_list + "\nPreRequisites: ";
            for(int j = 0;j<CourseList.get(i).preRequisites.length;j++) {
                courses_list = courses_list + CourseList.get(i).preRequisites + " ";
            }
            courses_list = courses_list + "\n======================================================================\n";
        }
        JOptionPane.showMessageDialog(null, courses_list);
    }




    public static void adminMenu(Admin admin) {
        while (true) {
            JOptionPane.showMessageDialog(null, "Please select an option\n (1)View Course\n (2)Add Course or Delete Course\n (3)Edit Student Details\n (4)Assign Professor to Course\n (5)Handle Complaints \n(6)Exit");
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
            if (choice == 1) {
                print_course();
            } else if (choice == 2) {
                JOptionPane.showMessageDialog(null, "Please select an option\n (1)Add Course\n (2)Delete Course");
                int choice1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
                if (choice1 == 1) {
                    String CCode = JOptionPane.showInputDialog(null, "Enter the Course Code");
                    String Course_name = JOptionPane.showInputDialog(null, "Enter the Course Name");
                    int Credits = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Credits"));
                    String Professor_name = JOptionPane.showInputDialog(null, "Enter the Professor Name");
                    int enrollement_limit = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Enrollment Limit"));
                    String class_timings = JOptionPane.showInputDialog(null, "Enter the Class Timings");
                    int number_of_preReq = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of PreRequisites"));
                    String[] preReq = new String[number_of_preReq];
                    for (int i = 0; i < number_of_preReq; i++) {
                        String preReq_course = JOptionPane.showInputDialog(null, "Enter the PreRequisite Course");
                        preReq[i]=preReq_course;
                    }
                    Course course = new Course(CCode, Credits, Course_name, Professor_name, enrollement_limit, class_timings, preReq);
                    CourseList.add(course);
                } else if (choice1 == 2) {
                    String CCode = JOptionPane.showInputDialog(null, "Enter the Course Code to delete");
                    try {
                        for (int i = 0; i < CourseList.size(); i++) {
                            if (CourseList.get(i).CCode.equals(CCode)) {
                                CourseList.remove(i);
                                JOptionPane.showMessageDialog(null, "Course deleted successfully");
                                break;
                            }
                        }
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Course does not exist");
                    }
                }
            } else if (choice == 3) {
                String email = JOptionPane.showInputDialog(null, "Enter the Student Email");
                for (int i = 0; i < Students.size(); i++) {
                    if (Students.get(i).email.equals(email)) {
                        JOptionPane.showMessageDialog(null, "What do you want to edit?\n (1) Email\n (2) Password\n (3) Course Grade\n (4) Credits\n (5) CGPA\n (6) Courses\n (7) Exit");
                        int choice2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
                        if (choice2 == 1) {
                            String new_email = JOptionPane.showInputDialog(null, "Enter the new Email");
                            Students.get(i).email = new_email;
                            JOptionPane.showMessageDialog(null, "Student details updated successfully");
                        } else if (choice2 == 2) {
                            String new_password = JOptionPane.showInputDialog(null, "Enter the new Password");
                            Students.get(i).password = new_password;
                            JOptionPane.showMessageDialog(null, "Student details updated successfully");
                        } else if (choice2 == 3) {
                            String select_course = JOptionPane.showInputDialog(null, "Which Course do you want to change it for?");
                            for (int j = 0; j < Students.get(i).courses.size(); j++) {
                                if (Students.get(i).courses.get(j).CCode.equals(select_course)) {
                                    String new_grade = JOptionPane.showInputDialog(null, "Enter the new Grade");
                                    Students.get(i).courses.get(j).Course_grade = new_grade;
                                    JOptionPane.showMessageDialog(null, "Student details updated successfully");
                                    List<Course> toBeMoved = new ArrayList<>();
                                    for (Student student : Students) {
                                        if (student.email.equals(email)) {
                                            for (Course course : student.courses) {
                                                if (course.Course_grade != null && !course.Course_grade.isEmpty()) {
                                                    toBeMoved.add(course);
                                                }
                                            }
                                            student.courses.removeAll(toBeMoved);
                                            student.completed_courses.addAll(toBeMoved);
                                        }
                                        boolean allGraded = true;
                                        for (Student student1 : Students) {
                                            for (Course course : student1.courses) {
                                                if (course.Course_grade == null || course.Course_grade.isEmpty()) {
                                                    allGraded = false;
                                                    break;
                                                }
                                            }
                                            if (!allGraded) break;
                                            if(allGraded){
                                                String CurrentSem = student1.getCurrentSemester();
                                                String newSem = CurrentSem.equals("Winter")?"Summer":"Winter";
                                                student1.setCurrentSemester(newSem);
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }    else if (choice2 == 4) {
                                    int new_credits = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the new Credits"));
                                    Student.Students.get(i).Credits = new_credits;
                                    JOptionPane.showMessageDialog(null, "Student details updated successfully");
                                } else if (choice2 == 5) {
                                    String new_cgpa = JOptionPane.showInputDialog(null, "Enter the new CGPA");
                                    Student.Students.get(i).CGPA = new_cgpa;
                                    JOptionPane.showMessageDialog(null, "Student details updated successfully");
                                } else if (choice2 == 6) {
                                    JOptionPane.showMessageDialog(null, "Do you want to add or remove courses?\n (1) Add\n (2) Remove");
                                    int choice3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
                                    String stringmaker = "The current courses that the student is enrolled in are: \n";
                                    for (int j = 0; j < Student.CourseList.size(); j++) {
                                        stringmaker += "Course Code: " + Student.CourseList.get(j).CCode;
                                        stringmaker += '\n';
                                    }
                                    JOptionPane.showMessageDialog(null, stringmaker);
                                    if (choice3 == 1) {
                                        String new_courses = JOptionPane.showInputDialog(null, "Enter the new Courses");
                                        if (Students.get(i).courses.contains(new_courses)) {
                                            JOptionPane.showMessageDialog(null, "Course already exists");
                                        } else {
                                            for (int k = 0; k < CourseList.size(); k++) {
                                                if (CourseList.get(k).CCode.equals(new_courses)) {
                                                    Students.get(i).courses.add(CourseList.get(k));
                                                    JOptionPane.showMessageDialog(null, "Student details updated successfully");
                                                    break;
                                                } else if (!CourseList.get(i).CCode.equals(new_courses)) {
                                                    JOptionPane.showMessageDialog(null, "Course does not exist");
                                                    break;
                                                }
                                            }
                                        }
                                    } else if (choice3 == 2) {
                                        String remove_courses = JOptionPane.showInputDialog(null, "Enter the Course to remove");
                                        for (int k = 0; k < Student.CourseList.size(); k++) {
                                            if (Student.CourseList.get(k).CCode.equals(remove_courses)) {
                                                Student.CourseList.remove(k);
                                                JOptionPane.showMessageDialog(null, "Student details updated successfully");
                                                break;
                                            } else if (!CourseList.get(i).CCode.equals(remove_courses)) {
                                                JOptionPane.showMessageDialog(null, "Course does not exist");
                                                break;
                                            }
                                        }
                                    }
                                } else if (choice2 == 7) {
                                    JOptionPane.showMessageDialog(null, "Exiting Student Menu");
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid choice");
                                    break;
                                }
                            }
                        }
                    } else if (choice == 4) {
                        String CCode = JOptionPane.showInputDialog(null, "Enter the Course Code");
                        String Professor_name = JOptionPane.showInputDialog(null, "Enter the Professor Name");
                        for (int i = 0; i < CourseList.size(); i++) {
                            if (CourseList.get(i).CCode.equals(CCode)) {
                                CourseList.get(i).Professor_name = Professor_name;
                                JOptionPane.showMessageDialog(null, "Professor assigned successfully");
                                break;
                            }
                        }
                    } else if (choice == 5) {
                        String stringmaker = " ";
                        for (int i = 0; i < Complaints.size(); i++) {
                            stringmaker += "Complaint ID: " + Complaints.get(i).Complaint_Code + "\nComplaint: " + Complaints.get(i).Complaint + "\nStatus: " + Complaints.get(i).show_status;
                            stringmaker += "\n======================================================================\n";
                        }
                        JOptionPane.showMessageDialog(null, stringmaker, "Complaints", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Please select an option\n (1)Change Status\n (2)Exit");
                        int choice1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice"));
                        if (choice1 == 1) {
                            int Complaint_Code = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Complaint Code"));
                            int new_status = JOptionPane.showOptionDialog(null, "Choose the new status", "Status", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Pending", "Resolved"}, null);
                            for (int i = 0; i < Complaints.size(); i++) {
                                if (Complaints.get(i).Complaint_Code == Complaint_Code) {
                                    if (new_status == 0) {
                                        Complaints.get(i).status = false;
                                        Complaints.get(i).show_status = "Pending";
                                    } else if (new_status == 1) {
                                        Complaints.get(i).status = true;
                                        Complaints.get(i).show_status = "Resolved";
                                    }
                                    JOptionPane.showMessageDialog(null, "Status updated successfully");
                                    break;
                                }
                            }
                        } else if (choice1 == 2) {
                            return;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid choice");
                        }
                    } else if (choice == 6) {
                        JOptionPane.showMessageDialog(null, "Exiting Admin Menu");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid choice");
                    }
                }
            }


    public static void initaliseAccs(){
        Admins.add(new Admin("admin","admin"));
    }

}