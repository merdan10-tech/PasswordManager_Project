package Week8.ProgrammingProject5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PasswordManager {
    private ArrayList<User> users;

    public PasswordManager() {
        users = new ArrayList<>();
    }

    public void addUser(String username, StringBuilder password) {

        // Create a new User and add it to the list of users
        User newUser = new User(username, password);
        users.add(newUser);
    }

    public void changeUserPassword(String username, String newPassword) {

        // Find the user by username and change their password
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.changePassword(newPassword);
                return; // User found and password changed, exit the loop
            }
        }

        // Handle the case where the user is not found
        System.out.println("User not found. Password not changed.");
    }

    public boolean isStrongPassword(String password) {

        // Check password strength criteria using regular expressions
        return password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[^a-zA-Z].*")
                && password.length() >= 8;
    }

    public void displayUsersAndPasswords() {

        // Display the list of all users and their passwords
        for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        }
    }

    public void removeUser(String username) {

        // Remove a user by their username
        users.removeIf(user -> user.getUsername().equals(username));
    }

    public ArrayList<User> getUsers() {
        return users;
    }

       public static void main(String[] args) {
        PasswordManager manager = new PasswordManager();
        boolean exit = false;

        while (!exit) {
            System.out.println("Password Manager Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Change Password");
            System.out.println("3. Check Password Strength");
            System.out.println("4. Display Users and Passwords");
            System.out.println("5. Remove User");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();


            switch (choice) {
                case 1:

                    // Handle adding a user
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    manager.addUser(username, new StringBuilder(password));
                    break;
                case 2:

                    // Handle changing a password
                    System.out.print("Enter username: ");
                    String usernameToChange = scanner.next();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.next();
                    manager.changeUserPassword(usernameToChange, newPassword);
                    break;
                case 3:

                    // Handle checking password strength
                    System.out.print("Enter a password to check its strength: ");
                    String passwordToCheck = scanner.next();
                    boolean isStrong = manager.isStrongPassword(passwordToCheck);
                    System.out.println("Password strength: " + (isStrong ? "Strong" : "Weak"));
                    break;
                case 4:

                    // Handle displaying users and passwords
                    manager.displayUsersAndPasswords();
                    break;
                case 5:

                    // Handle removing a user
                    System.out.print("Enter username to remove: ");
                    String usernameToRemove = scanner.next();
                    manager.removeUser(usernameToRemove);
                    break;

                    // Exits from the switch statement
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        }
    }
}

