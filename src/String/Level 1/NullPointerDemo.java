public class NullPointerDemo {

    public static void generateException() {
        String text = null;
        text.length();
    }

    public static void handleException() {
        try {
            String text = null;
            text.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled");
        }
    }

    public static void main(String[] args) {
        try {
            generateException();
        } catch (Exception e) {
            handleException();
        }
    }
}
