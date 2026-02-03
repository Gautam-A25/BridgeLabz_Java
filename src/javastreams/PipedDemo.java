package javacollectionstreams.iostreams;
import java.io.*;

/*
 Program: Piped Streams for inter-thread communication
*/

public class PipedDemo {
    public static void main(String[] args) throws Exception {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        // Writer thread
        new Thread(() -> {
            try {
                pos.write("Hello from Thread!".getBytes());
                pos.close();
            } catch (IOException e) {}
        }).start();

        // Reader thread
        new Thread(() -> {
            try {
                int data;
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }
            } catch (IOException e) {}
        }).start();
    }
}

