import java.util.Scanner;

class Quadratic {

    public static double[] findRoots(double a, double b, double c) {

        double delta = b * b - 4 * a * c;

        if (delta < 0) return new double[0];

        if (delta == 0) {
            return new double[]{-b / (2 * a)};
        }

        double r1 = (-b + Math.sqrt(delta)) / (2 * a);
        double r2 = (-b - Math.sqrt(delta)) / (2 * a);

        return new double[]{r1, r2};
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double[] roots = findRoots(a, b, c);

        for (double r : roots) {
            System.out.println(r);
        }

        input.close();
    }
}
