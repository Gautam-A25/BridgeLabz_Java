public class PenDistribution {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;
        int pensPerStudent = totalPens / students;
        int remainingPens = totalPens % students;

        System.out.println("Each student gets " + pensPerStudent + " pens.");
        System.out.println("Remaining pens in the box: " + remainingPens);
    }
}
