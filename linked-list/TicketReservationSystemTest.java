import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

// Ticket class representing a ticket node in the circular linked list
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    // Constructor to initialize ticket details
    public Ticket(int ticketId, String customerName, String movieName, String seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = getCurrentTime();
        this.next = null;
    }

    // Method to get current time in the format of yyyy-MM-dd HH:mm:ss
    private String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }
}

// OnlineTicketReservationSystem class to manage the circular linked list of ticket reservations
class OnlineTicketReservationSystem {
    Ticket head;

    // Constructor to initialize the circular linked list
    public OnlineTicketReservationSystem() {
        this.head = null;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);

        if (head == null) {
            head = newTicket;
            newTicket.next = head;  // Circular link
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;  // Circular link
        }

        System.out.println("Ticket reserved successfully for " + customerName + " for the movie " + movieName);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;
        
        // If the ticket to be removed is the head node
        if (head.ticketId == ticketId) {
            // Find the last node
            Ticket last = head;
            while (last.next != head) {
                last = last.next;
            }

            // If only one node exists
            if (head.next == head) {
                head = null;
            } else {
                head = head.next;
                last.next = head;  // Update the circular link
            }
            System.out.println("Ticket with ID " + ticketId + " removed.");
            return;
        }

        // Traverse the list to find the ticket
        while (temp != null && temp.ticketId != ticketId) {
            prev = temp;
            temp = temp.next;
            if (temp == head) break;  // List is circular, prevent infinite loop
        }

        if (temp != null && temp.ticketId == ticketId) {
            prev.next = temp.next;  // Remove the ticket by updating the previous node's next pointer
            System.out.println("Ticket with ID " + ticketId + " removed.");
        } else {
            System.out.println("Ticket with ID " + ticketId + " not found.");
        }
    }

    // Display all tickets in the circular linked list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName + ", Movie: " + temp.movieName +
                               ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);  // Loop back to the head for circular traversal
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(searchTerm) || temp.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName + ", Movie: " + temp.movieName +
                                   ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);  // Loop back to the head for circular traversal

        if (!found) {
            System.out.println("No tickets found for search term: " + searchTerm);
        }
    }

    // Calculate and display the total number of booked tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total number of booked tickets: " + count);
    }
}

// Main class to test the Online Ticket Reservation System
public class TicketReservationSystemTest {
    public static void main(String[] args) {
        OnlineTicketReservationSystem system = new OnlineTicketReservationSystem();

        // Add tickets
        system.addTicket(101, "John Doe", "Avengers: Endgame", "A1");
        system.addTicket(102, "Jane Smith", "Spider-Man: No Way Home", "B2");
        system.addTicket(103, "Sam Brown", "Batman", "C3");

        // Display all tickets
        system.displayTickets();

        // Search for tickets by customer name or movie name
        system.searchTicket("John Doe");
        system.searchTicket("Avengers: Endgame");

        // Count total tickets
        system.countTickets();

        // Remove a ticket by Ticket ID
        system.removeTicket(102);  // Remove ticket with ID 102

        // Display all tickets after removal
        system.displayTickets();

        // Count total tickets after removal
        system.countTickets();
    }
}
