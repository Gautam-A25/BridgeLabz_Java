package javacollectionstreams.regex.advanced.password;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    // Creating PasswordValidator object
    PasswordValidator validator = new PasswordValidator();

    // Test valid password
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
    }

    // Test invalid password
    @Test
    void testInvalidPassword() {
        assertFalse(validator.isValid("pass"));
    }
}

