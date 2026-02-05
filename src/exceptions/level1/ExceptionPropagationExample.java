package javacollectionstreams.exceptionhandling.level1;
public class ExceptionPropagationExample {

    /*
     Multi-line comment:
     method1() generates an exception.
     It performs division by zero.
    */
    static void method1() {
        // Single-line comment:
        // This will cause ArithmeticException
        int result = 10 / 0;
    }

    /*
     Multi-line comment:
     method2() does not handle exception.
     It propagates it to the caller.
    */
    static void method2() {
        method1();   // Exception propagates from method1()
    }

    public static void main(String[] args) {

        /*
         main() handles the exception
         coming from method2().
        */
        try {
            method2();   // Exception propagates from method2()
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}

