package linkedlist;

/*
9. Circular Linked List: Online Ticket Reservation System
Problem Statement: Design an online ticket reservation system using a circular linked list,
where each node represents a booked ticket with:
Ticket ID, Customer Name, Movie Name, Seat Number, Booking Time.

Implement:
- Add a new ticket reservation at the end of the circular list.
- Remove a ticket by Ticket ID.
- Display current tickets.
- Search by Customer Name or Movie Name.
- Calculate total number of booked tickets.

Hint:
- Circular list: last.next = head
- Stop traversal after one full cycle.
*/

// Node class (each node is a Ticket)
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationCLL {
    private Ticket head = null;

    // Add new ticket at end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newNode = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Ticket temp = head;
        while (temp.next != head) temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    // Remove ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        do {
            if (temp.ticketId == ticketId) {

                // Only one ticket
                if (temp == head && temp.next == head) {
                    head = null;
                    System.out.println("Ticket removed: " + ticketId);
                    return;
                }

                // Deleting head
                if (temp == head) {
                    Ticket last = head;
                    while (last.next != head) last = last.next;

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }

                temp.next = null; // cleanup
                System.out.println("Ticket removed: " + ticketId);
                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("\n---- Booked Tickets ----");
        Ticket temp = head;
        do {
            System.out.println("TicketID=" + temp.ticketId +
                    " | " + temp.customerName +
                    " | " + temp.movieName +
                    " | Seat=" + temp.seatNumber +
                    " | Time=" + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by customer name
    public void searchByCustomerName(String name) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                System.out.println("Found Ticket: " + temp.ticketId +
                        " for " + temp.customerName +
                        " | Movie=" + temp.movieName +
                        " | Seat=" + temp.seatNumber +
                        " | Time=" + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for customer: " + name);
        }
    }

    // Search by movie name
    public void searchByMovieName(String movie) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                System.out.println("Found Ticket: " + temp.ticketId +
                        " | Customer=" + temp.customerName +
                        " | Seat=" + temp.seatNumber +
                        " | Time=" + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for movie: " + movie);
        }
    }

    // Count total tickets
    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

public class TicketNode {
    public static void main(String[] args) {

        TicketReservationCLL system = new TicketReservationCLL();

        system.addTicket(501, "Varun", "Interstellar", "A10", "10:30 AM");
        system.addTicket(502, "Rahul", "Inception", "B5", "11:00 AM");
        system.addTicket(503, "Asha", "Interstellar", "A11", "10:35 AM");

        system.displayTickets();

        system.searchByCustomerName("Varun");
        system.searchByMovieName("Interstellar");

        System.out.println("\nTotal Tickets Booked = " + system.countTickets());

        system.removeTicket(502);
        system.displayTickets();
    }
}
