package object_oriented_programming.Keywords;

class Book{
    private static String libraryName = "Blue Tokai Library";

    private String title,author;
    private final int isbn;

    Book(String title, String author, int isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;

    }

    public static void displayLibraryName(){
        System.out.println("Library Name: " + libraryName);
    }

    public void  displayDetails(){
        if(this instanceof Book) {
            System.out.println("Book Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }else{
            System.out.println("Invalid Book object");
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args){
        Book.displayLibraryName();

        Book b1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 12345);
        Book b2 = new Book("Three Men in a Boat", "Jerome K. Jerome", 67890);

        b1.displayDetails();
        System.out.println("-------------------");
        b2.displayDetails();

    }
}
