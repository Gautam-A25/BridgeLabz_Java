package javacollectionstreams.exceptionhandling.level2;
import java.util.Scanner;

/* Custom exception if user exists */
class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}

/* Custom exception if user not found */
class UserNotFoundException extends Exception {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}

class UserService {

    // Throws custom exception
    void registerUser(String username) throws UserAlreadyExistsException {
        if (username.equals("admin")) {
            throw new UserAlreadyExistsException("User already exists!");
        }
        System.out.println("User registered: " + username);
    }

    void checkUserExistence(String username) throws UserNotFoundException {
        if (!username.equals("admin")) {
            throw new UserNotFoundException("User not found!");
        }
        System.out.println("User exists: " + username);
    }

    public static void main(String[] args) {

        // User input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        UserService us = new UserService();

        try {
            us.checkUserExistence(name);
            us.registerUser(name);
        } catch (UserNotFoundException | UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }
}

