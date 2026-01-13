package Constructors;
import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;

    Book() {
        title = "Not Assigned";
        author = "Not Assigned";
        price = 0.0;
    }

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class BookConstructorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book b1 = new Book();
        b1.display();

        String title = sc.nextLine();
        String author = sc.nextLine();
        double price = sc.nextDouble();

        Book b2 = new Book(title, author, price);
        b2.display();

        sc.close();
    }
}

