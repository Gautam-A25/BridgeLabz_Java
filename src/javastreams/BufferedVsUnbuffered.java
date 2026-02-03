package javastreams;
import java.io.*;

public class BufferedVsUnbuffered {
    static void copyUnbuffered(String src, String dest) throws IOException {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    static void copyBuffered(String src, String dest) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        copyUnbuffered("bigfile.dat", "unbuffered.dat");
        long end = System.nanoTime();
        System.out.println("Unbuffered Time: " + (end - start));

        start = System.nanoTime();
        copyBuffered("bigfile.dat", "buffered.dat");
        end = System.nanoTime();
        System.out.println("Buffered Time: " + (end - start));
    }
}
