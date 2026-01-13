package Constructors;

import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;
    boolean available;

    Book(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book is not available");
        }
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + available);
    }
}

public class LibraryBookSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String title = sc.nextLine();
        String author = sc.nextLine();
        double price = sc.nextDouble();

        Book book = new Book(title, author, price, true);

        book.displayDetails();
        book.borrowBook();
        book.displayDetails();

        sc.close();
    }
}

