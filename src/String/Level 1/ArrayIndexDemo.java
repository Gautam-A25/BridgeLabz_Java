import java.util.Scanner;

public class ArrayIndexDemo {

    public static void generateException(String[] arr) {
        System.out.println(arr[arr.length]);
    }

    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] arr = new String[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.next();
        }

        try {
            generateException(arr);
        } catch (Exception e) {
            handleException(arr);
        }
    }
}
