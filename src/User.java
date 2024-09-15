import java.util.HashMap;
import java.util.Map;

public class User {
    String email;
    String password;
    static HashMap<String, String> Students = new HashMap< String, String>();
    static Map<String, String> Professors;
    static Map<String, String> Admins;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public User() {

    }
}
