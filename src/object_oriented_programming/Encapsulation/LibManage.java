package object_oriented_programming.Encapsulation;

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    LibraryItem(int id, String title, String author) {
        this.itemId = id;
        this.title = title;
        this.author = author;
    }

    abstract int getLoanDuration();

    void getItemDetails() {
        System.out.println(title + " by " + author);
    }
}

class Book extends LibraryItem {
    Book(int id, String t, String a) {
        super(id, t, a);
    }

    int getLoanDuration() {
        return 14;
    }
}

public class LibManage {
    public static void main(String[] args) {
        LibraryItem item = new Book(1, "1984", "Orwell");
        item.getItemDetails();
    }
}

