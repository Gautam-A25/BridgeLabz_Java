package object_oriented_programming.ObjectModelling;

import java.util.ArrayList;

class Books{
    private String title;
    private String author;

    Books(String title, String author){
        this.title = title;
        this.author = author;
    }

    public void displayBook(){
        System.out.println("Book Title: " + title + " | Written By: " + author);
    }
}

class Library{
    private String libName;
    private ArrayList<Books> books;

    Library(String libName){
        this.libName = libName;
        this.books = new ArrayList<>();
    }

    public void addBooks(Books book){
        books.add(book);
    }

    public void displayLibrary(){
        System.out.println("Library Name: " + libName);
        System.out.println("Books in this library:");
        for (Books b : books) {
            b.displayBook();
        }
        System.out.println();
    }
}


public class LibraryBooksAggregator {
    public static void main(String[] args){
        Books b1 = new Books("The Alchemist", "Paulo Coelho");
        Books b2 = new Books("Clean Code", "Robert C. Martin");
        Books b3 = new Books("1984", "George Orwell");

        Library lib1 = new Library("Anna Centenary Library");
        Library lib2 = new Library("Eswari Lending Library");

        lib1.addBooks(b1);
        lib2.addBooks(b2);
        lib2.addBooks(b3);

        lib1.displayLibrary();
        lib2.displayLibrary();
    }
}
