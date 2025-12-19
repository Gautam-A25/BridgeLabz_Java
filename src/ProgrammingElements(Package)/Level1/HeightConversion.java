import java.util.Scanner;


class HeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double heightCm = input.nextDouble();
        double inches = heightCm / 2.54;
        int feet = (int) (inches / 12);
        double remainingInches = inches % 12;
        System.out.println(
            "Your Height in cm is " + heightCm +
            " while in feet is " + feet +
            " and inches is " + remainingInches
        );
        input.close();
    }
}
        