class ZaraBonus {

    public static int[][] generateEmployeeData() {
        int[][] data = new int[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = (int)(Math.random()*90000)+10000;
            data[i][1] = (int)(Math.random()*10)+1;
        }
        return data;
    }

    public static double[][] calculateBonus(int[][] data) {
        double[][] result = new double[10][2];

        for (int i = 0; i < 10; i++) {
            double bonusRate = data[i][1] > 5 ? 0.05 : 0.02;
            double bonus = data[i][0] * bonusRate;
            result[i][0] = data[i][0] + bonus;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] emp = generateEmployeeData();
        double[][] result = calculateBonus(emp);

        double totalBonus = 0;

        System.out.println("OldSalary\tYears\tNewSalary\tBonus");
        for (int i = 0; i < 10; i++) {
            totalBonus += result[i][1];
            System.out.println(
                emp[i][0] + "\t\t" + emp[i][1] + "\t" +
                result[i][0] + "\t" + result[i][1]
            );
        }
        System.out.println("Total Bonus Paid: " + totalBonus);
    }
}
