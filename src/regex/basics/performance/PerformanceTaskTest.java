package javacollectionstreams.regex.basics.performance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTaskTest {

    // Creating object of PerformanceTask
    PerformanceTask task = new PerformanceTask();

    // Test fails if method takes more than 2 seconds
    @Test
    @Timeout(2)
    void testTimeout() throws InterruptedException {
        task.longRunningTask();
    }
}
