package Week8.ProgrammingProject5;

public class User {

    // Declare attributes
    private String username; 
    private StringBuilder password;

    // Implement a constructor 
    public User(String username, StringBuilder password) {
        this.username = username;
        this.password = password;
        
    }

    // Replacement of old password with new one
    public void changePassword(String newPassword) {
        this.password = new StringBuilder(newPassword);
    }

    // Getter function

    public String getUsername() {
        return username;

    }

    public StringBuilder getPassword() {
        return password;
    }
}
