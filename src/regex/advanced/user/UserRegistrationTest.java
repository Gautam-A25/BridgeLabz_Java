package javacollectionstreams.regex.advanced.user;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    // Creating UserRegistration object
    UserRegistration registration = new UserRegistration();

    // Test valid user registration
    @Test
    void testValidUser() {
        assertTrue(registration.registerUser("varsha", "varsha@gmail.com", "secret1"));
    }

    // Test invalid user registration
    @Test
    void testInvalidUser() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("", "invalid", "123");
        });
    }
}
