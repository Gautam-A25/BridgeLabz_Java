import java.util.Scanner;

public class NumberGuessingGame {

    public static int generateGuess(int low, int high) {
        return low + (high - low) / 2;
    }

    public static String getFeedback(Scanner sc) {
        return sc.next().toLowerCase();
    }

    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        String feedback;

        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            feedback = getFeedback(sc);

            if (feedback.equals("correct")) {
                System.out.println("Guessed correctly!");
                break;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
