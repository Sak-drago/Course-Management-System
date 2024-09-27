public class Feedback<T> {
    private String courseCode;
    private String studentEmail;
    private T feedback;

    public Feedback(String courseCode, String studentEmail, T feedback) {
        this.courseCode = courseCode;
        this.studentEmail = studentEmail;
        this.feedback = feedback;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public T getFeedback() {
        return feedback;
    }

    @Override
    public String toString() {
        return "Course: " + courseCode + ", Student: " + studentEmail + ", Feedback: " + feedback.toString();
    }
}
