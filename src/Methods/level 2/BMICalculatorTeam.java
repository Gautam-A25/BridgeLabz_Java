import java.util.Scanner;

class BMICalculatorTeam {

    public static void calculateBMI(double[][] data) {

        for (int i = 0; i < data.length; i++) {
            double h = data[i][1] / 100;
            data[i][2] = data[i][0] / (h * h);
        }
    }

    public static String getStatus(double bmi) {

        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[][] persons = new double[10][3];

        for (int i = 0; i < 10; i++) {
            persons[i][0] = input.nextDouble();
            persons[i][1] = input.nextDouble();
        }

        calculateBMI(persons);

        for (int i = 0; i < 10; i++) {
            System.out.println(persons[i][2] + " " + getStatus(persons[i][2]));
        }

        input.close();
    }
}
