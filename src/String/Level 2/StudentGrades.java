public class StudentGrades {

    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 50 + (int) (Math.random() * 50);
            }
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = Math.round((total / 300.0) * 10000) / 100.0;
            stats[i][0] = total;
            stats[i][1] = avg;
            stats[i][2] = percent;
        }
        return stats;
    }

    public static String grade(double percent) {
        if (percent >= 90) return "A";
        if (percent >= 75) return "B";
        if (percent >= 60) return "C";
        return "D";
    }

    public static void main(String[] args) {
        int[][] scores = generateScores(5);
        double[][] stats = calculateStats(scores);

        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i][0] + " " + scores[i][1] + " " +
                    scores[i][2] + " " + stats[i][0] + " " +
                    stats[i][1] + " " + stats[i][2] + " " +
                    grade(stats[i][2]));
        }
    }
}
