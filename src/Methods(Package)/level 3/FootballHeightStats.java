class FootballHeightStats {

    public static int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) s += arr[i];
        return s;
    }

    public static double mean(int[] arr) {
        return sum(arr) / (double) arr.length;
    }

    public static int min(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) m = Math.min(m, arr[i]);
        return m;
    }

    public static int max(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) m = Math.max(m, arr[i]);
        return m;
    }

    public static void main(String[] args) {

        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }

        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + " Height: " + heights[i]);
        }

        System.out.println("Minimum Height: " + min(heights));
        System.out.println("Maximum Height: " + max(heights));
        System.out.println("Average Height: " + mean(heights));
    }
}
