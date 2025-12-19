import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ages
        int amarAge = input.nextInt();
        int akbarAge = input.nextInt();
        int anthonyAge = input.nextInt();

        // Heights
        double amarHeight = input.nextDouble();
        double akbarHeight = input.nextDouble();
        double anthonyHeight = input.nextDouble();

        // Find youngest
        String youngest;
        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            youngest = "Amar";
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }

        // Find tallest
        String tallest;
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            tallest = "Amar";
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }

        System.out.println("The youngest friend is " + youngest);
        System.out.println("The tallest friend is " + tallest);

        input.close();
    }
}
