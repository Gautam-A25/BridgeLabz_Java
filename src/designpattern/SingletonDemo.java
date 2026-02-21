package designpattern;
class Logger {

    private static Logger instance;

    private Logger() {
        System.out.println("Logger Created");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {

        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        log1.log("First Message");
        log2.log("Second Message");

        System.out.println(log1 == log2); // true
    }
}