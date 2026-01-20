package linkedlist;

/*
5. Doubly Linked List: Library Management System
Problem Statement: Design a library management system using a doubly linked list.
Each node represents a book and contains:
Book Title, Author, Genre, Book ID, and Availability Status.

Implement:
- Add a new book at the beginning, end, or at a specific position.
- Remove a book by Book ID.
- Search for a book by Book Title or Author.
- Update a book’s Availability Status.
- Display all books in forward and reverse order.
- Count the total number of books in the library.

Hint:
- Doubly linked list with next and prev pointers.
- Update both pointers correctly on deletion.
- Reverse display uses tail traversal.
*/

// Node class (represents a Book in DLL)
class Book {
    String title, author, genre;
    int bookId;
    boolean available;
    Book next, prev;

    Book(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class
class LibraryDLL {
    private Book head, tail;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean available) {
        Book newNode = new Book(title, author, genre, bookId, available);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean available) {
        Book newNode = new Book(title, author, genre, bookId, available);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean available) {

        if (pos <= 1) {
            addAtBeginning(title, author, genre, bookId, available);
            return;
        }

        Book temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, bookId, available);
            return;
        }

        Book newNode = new Book(title, author, genre, bookId, available);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void removeById(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {

                if (temp == head) {
                    head = head.next;
                }

                if (temp == tail) {
                    tail = tail.prev;
                }

                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }

                // Fix head.prev and tail.next after deletion
                if (head != null) {
                    head.prev = null;
                }

                if (tail != null) {
                    tail.next = null;
                }

                temp.next = null;
                temp.prev = null;

                System.out.println("Book removed: " + bookId);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Found Book: " + temp.title +
                        " | Author=" + temp.author +
                        " | Genre=" + temp.genre +
                        " | ID=" + temp.bookId +
                        " | Available=" + temp.available);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No book found with title: " + title);
        }
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Found Book: " + temp.title +
                        " | Author=" + temp.author +
                        " | Genre=" + temp.genre +
                        " | ID=" + temp.bookId +
                        " | Available=" + temp.available);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.available = status;
                System.out.println("Availability updated for Book ID: " + bookId);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\n---- Library Forward ----");
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | Available=" + temp.available);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\n---- Library Reverse ----");
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | Available=" + temp.available);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class BookNode {
    public static void main(String[] args) {

        LibraryDLL lib = new LibraryDLL();

        lib.addAtEnd("Clean Code", "Robert Martin", "Programming", 301, true);
        lib.addAtBeginning("Atomic Habits", "James Clear", "Self Help", 302, true);
        lib.addAtPosition(2, "Rich Dad Poor Dad", "Robert Kiyosaki", "Finance", 303, false);

        lib.displayForward();
        lib.displayReverse();

        lib.searchByAuthor("Robert Martin");
        lib.updateAvailability(303, true);

        System.out.println("\nTotal Books = " + lib.countBooks());

        lib.removeById(302);
        lib.displayForward();
    }
}