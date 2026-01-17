import java.util.Scanner;
class Handshakes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfStudents = input.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        
        System.out.println(
            "The maximum number of handshakes possible is " + handshakes
        );
        input.close();
    }
}
