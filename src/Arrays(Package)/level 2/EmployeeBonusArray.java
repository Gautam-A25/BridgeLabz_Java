import java.util.Scanner;

class EmployeeBonusArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = 10;

        double[] salary = new double[size];
        double[] years = new double[size];
        double[] bonus = new double[size];
        double[] newSalary = new double[size];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < size; i++) {
            double s = input.nextDouble();
            double y = input.nextDouble();

            if (s <= 0 || y < 0) {
                i--;
                continue;
            }

            salary[i] = s;
            years[i] = y;
        }

        for (int i = 0; i < size; i++) {
            if (years[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];

            System.out.println(
                "Employee " + (i + 1) + " " +
                salary[i] + " " +
                years[i] + " " +
                bonus[i] + " " +
                newSalary[i]
            );
        }

        System.out.println(totalBonus);
        System.out.println(totalOldSalary);
        System.out.println(totalNewSalary);

        input.close();
    }
}
