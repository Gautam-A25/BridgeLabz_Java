class RandomStats {

    public static int[] generate4DigitRandomArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 9000) + 1000;
        }

        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {

        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        double average = sum / (double) numbers.length;

        return new double[]{average, min, max};
    }

    public static void main(String[] args) {

        int[] numbers = generate4DigitRandomArray(5);
        System.out.println("Generated numbers:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        double[] stats = findAverageMinMax(numbers);

        System.out.println("Average, Min, Max:");
        System.out.println(stats[0]);
        System.out.println(stats[1]);
        System.out.println(stats[2]);
    }
}
