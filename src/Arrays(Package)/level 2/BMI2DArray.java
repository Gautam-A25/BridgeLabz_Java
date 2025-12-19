import java.util.Scanner;

class BMI2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        double[][] personData = new double[number][3];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            double w = input.nextDouble();
            double h = input.nextDouble();

            if (w <= 0 || h <= 0) {
                i--;
                continue;
            }

            personData[i][0] = w;
            personData[i][1] = h;
        }

        for (int i = 0; i < number; i++) {
            double heightM = personData[i][1] / 100;
            personData[i][2] = personData[i][0] / (heightM * heightM);

            if (personData[i][2] < 18.5) status[i] = "Underweight";
            else if (personData[i][2] < 25) status[i] = "Normal";
            else if (personData[i][2] < 30) status[i] = "Overweight";
            else status[i] = "Obese";

            System.out.println(
                "Person " + (i + 1) + " " +
                personData[i][1] + " " +
                personData[i][0] + " " +
                personData[i][2] + " " +
                status[i]
            );
        }

        input.close();
    }
}
