import java.util.List;

public class Course{
    public String CourseCode ;
    public int Credits ;
    public String Course_name ;
    public String Professor_name ;
    //private String[] prerequisites;
    public int enrollement_limit ;
    public String class_timings ;

    public Course(String CCode, int Cred, String name, String Professor_taking, int limit, String timings){
        this.CourseCode = CCode;
        this.Credits = Cred;
        this.Course_name =  name;
        this.Professor_name = Professor_taking;
        //private String[] prerequisites;
        this.enrollement_limit= limit;
        this.class_timings = timings;

    }
}
