package designpattern;

// Old class
class OldPrinter {
    public void oldPrint(String text) {
        System.out.println("Old Printer: " + text);
    }
}

// Target interface
interface NewPrinter {
    void print(String text);
}

// Adapter
class PrinterAdapter implements NewPrinter {

    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    public void print(String text) {
        oldPrinter.oldPrint(text);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {

        OldPrinter oldPrinter = new OldPrinter();
        NewPrinter adapter = new PrinterAdapter(oldPrinter);

        adapter.print("Hello Nehaa!");
    }
}
