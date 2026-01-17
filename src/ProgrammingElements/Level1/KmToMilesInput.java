public class KmToMilesInput {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();
        
        double miles = km / 1.6;
        System.out.println(km + " kilometers is equal to " + miles + " miles.");
        sc.close();
    }
}
