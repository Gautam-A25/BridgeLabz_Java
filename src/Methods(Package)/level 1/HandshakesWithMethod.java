import java.util.Scanner;

public class HandshakesWithMethod {

    // Method to calculate maximum handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfStudents = input.nextInt();

        int handshakes = calculateHandshakes(numberOfStudents);

        System.out.println("The maximum number of handshakes is " + handshakes);

        input.close();
    }
}
