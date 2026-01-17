import java.util.Scanner;

class BMIMultiple {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            double w = input.nextDouble();
            double h = input.nextDouble();

            if (w <= 0 || h <= 0) {
                i--;
                continue;
            }

            weight[i] = w;
            height[i] = h;
        }

        for (int i = 0; i < number; i++) {
            double heightM = height[i] / 100;
            bmi[i] = weight[i] / (heightM * heightM);

            if (bmi[i] < 18.5) status[i] = "Underweight";
            else if (bmi[i] < 25) status[i] = "Normal";
            else if (bmi[i] < 30) status[i] = "Overweight";
            else status[i] = "Obese";

            System.out.println(
                "Person " + (i + 1) + " " +
                height[i] + " " +
                weight[i] + " " +
                bmi[i] + " " +
                status[i]
            );
        }

        input.close();
    }
}
