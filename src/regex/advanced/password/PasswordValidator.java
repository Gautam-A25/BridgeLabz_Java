package javacollectionstreams.regex.advanced.password;

public class PasswordValidator {

    // Checks password validity based on rules
    public boolean isValid(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*");
    }
}
