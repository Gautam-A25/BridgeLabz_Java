package object_oriented_programming.Constructors;

import java.util.Scanner;

class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    void display() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }
}

public class HotelBookingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HotelBooking b1 = new HotelBooking();
        b1.display();

        String name = sc.nextLine();
        String room = sc.nextLine();
        int nights = sc.nextInt();

        HotelBooking b2 = new HotelBooking(name, room, nights);
        b2.display();

        HotelBooking b3 = new HotelBooking(b2);
        b3.display();

        sc.close();
    }
}
