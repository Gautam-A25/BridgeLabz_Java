package javacollectionstreams.exceptionhandling.level2;
import java.util.Scanner;

/*
 Simulated connection class
*/
class FakeConnection {

    void open() {
        System.out.println("Connection opened");
    }

    void close() {
        System.out.println("Connection closed");
    }

    void process() {
        throw new RuntimeException("Processing error");
    }
}

public class ResourceCleanupExample {

    public static void main(String[] args) {

        // Creating resource
        FakeConnection conn = new FakeConnection();

        try {
            conn.open();
            conn.process();
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // Always executes
            conn.close();
        }
    }
}
