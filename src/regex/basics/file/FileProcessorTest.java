package javacollectionstreams.regex.basics.file;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FileProcessorTest {

    // Creating FileProcessor object
    FileProcessor processor = new FileProcessor();

    // Test to verify file write and read
    @Test
    void testFileWriteRead() throws Exception {
        processor.writeToFile("test.txt", "Hello");
        assertEquals("Hello", processor.readFromFile("test.txt"));
    }
}

