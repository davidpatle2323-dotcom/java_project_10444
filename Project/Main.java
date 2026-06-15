class Passenger {
    private String name;
    private int id;

    public Passenger(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
class Flight {
    private final int MAX_SEATS;
    private Passenger[] seats;

    public Flight(int capacity) {
        this.MAX_SEATS = capacity;
        seats = new Passenger[MAX_SEATS];
        System.out.println("Flight Created with " + MAX_SEATS + " seats.");
    }
    public boolean bookSeat(Passenger p) {

        // Check duplicate booking
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null && seats[i].getId() == p.getId()) {
                System.out.println("Passenger already booked: " + p.getName());
                return false;
            }
        }
        // Assign seat
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = p;
                System.out.println("Passenger " + p.getName() + " booked successfully.");
                return true;
            }
        }
        // If full
        System.out.println("Flight Full! Booking failed for Passenger: " + p.getName());
        return false;
    }
    // Display seat status
   public void displaySeats() {
    System.out.println("\nSeat Status:");
    for (int i = 0; i < MAX_SEATS; i++) {
        if (seats[i] == null) {
            System.out.println("Seat " + (i + 1) + ": Empty");
        } else {
            System.out.println(
                "Seat " + (i + 1) +
                ": Booked - " +
                seats[i].getName() +
                " (ID: " +
                seats[i].getId() + ")"
            );
        }
    }
}
}
public class Main {
    public static void main(String[] args) {
        // Create flight
        Flight flight = new Flight(5);
        // Create passengers
        Passenger p1 = new Passenger("Aman", 1);
        Passenger p2 = new Passenger("Rahul", 2);
        Passenger p3 = new   Passenger("Riya", 3);
        Passenger p4 = new Passenger("Neha", 4);
        Passenger p5 = new Passenger("Arjun", 5);
        Passenger p6 = new Passenger("Simran", 6);
        // Booking seats
        flight.bookSeat(p1);
        flight.bookSeat(p2);
        flight.bookSeat(p3);
        flight.bookSeat(p4);
        flight.bookSeat(p5);
        // Try duplicate booking
        flight.bookSeat(p1);
        // Try booking when full
        flight.bookSeat(p6);
        // Display seats
        flight.displaySeats();
    }
}