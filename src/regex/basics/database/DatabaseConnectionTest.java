package javacollectionstreams.regex.basics.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    DatabaseConnection db;

    // Runs before each test
    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    // Runs after each test
    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    // Dummy test to verify setup and cleanup
    @Test
    void testConnection() {
    }
}
