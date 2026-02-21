package reflectionandannotations.reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

/*
 * Program to dynamically invoke methods using Reflection
 */
class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            Class<?> clazz = MathOperations.class;

            Object object = clazz.getDeclaredConstructor().newInstance();

            Method method = clazz.getMethod(methodName, int.class, int.class);

            int result = (int) method.invoke(object, num1, num2);

            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name entered!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
