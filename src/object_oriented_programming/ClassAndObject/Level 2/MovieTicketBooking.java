import java.util.Scanner;

class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    MovieTicket(String movieName) {
        this.movieName = movieName;
    }

    void bookTicket(int seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void displayTicket() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }
}

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String movieName = sc.nextLine();
        int seatNumber = sc.nextInt();
        double price = sc.nextDouble();

        MovieTicket ticket = new MovieTicket(movieName);
        ticket.bookTicket(seatNumber, price);
        ticket.displayTicket();

        sc.close();
    }
}
