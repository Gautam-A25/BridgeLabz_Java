import java.util.Scanner;


class BMICalculator {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        double weight = input.nextDouble();
        double heightCm = input.nextDouble();
        double heightM = heightCm / 100;


        double bmi = weight / (heightM * heightM);


        System.out.println(bmi);


        input.close();
    }
}
