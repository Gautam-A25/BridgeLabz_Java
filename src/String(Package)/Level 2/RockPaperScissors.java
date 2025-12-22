import java.util.Scanner;

public class RockPaperScissors {

    public static String computerChoice() {
        int r = (int) (Math.random() * 3);
        return r == 0 ? "rock" : r == 1 ? "paper" : "scissors";
    }

    public static String winner(String user, String comp) {
        if (user.equals(comp)) return "draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper")))
            return "user";
        return "computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int games = sc.nextInt();

        int userWins = 0, compWins = 0;

        for (int i = 0; i < games; i++) {
            String user = sc.next();
            String comp = computerChoice();
            String win = winner(user, comp);

            if (win.equals("user")) userWins++;
            else if (win.equals("computer")) compWins++;
        }

        System.out.println(userWins + " " + compWins);
    }
}
