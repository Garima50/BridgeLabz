
import java.util.ArrayList;

class Flight {

    int flightId;
    String flightName;
    int totalSeats;
    int bookedSeats;
    double ticketPrice;

    Flight(int flightId, String flightName, int totalSeats, double ticketPrice) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.totalSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.bookedSeats = 0;
    }

    // to display flight info
    public void display() {
        System.out.println(flightId + ", " + flightName + ", Total Seats: " + totalSeats + ", Booked Seats: " + bookedSeats + ", Available Seats: " + (totalSeats - bookedSeats));
    }
}

// main class
public class AirlineReserveSystem {
    public static void main(String[] args) {
        
        ArrayList<Flight> flights = new ArrayList<>();

        // add flights to the system
        flights.add(new Flight(101, "Delhi-Mumbai", 100, 5000));
        flights.add(new Flight(102, "Delhi-Bangalore", 130, 6000));
        flights.add(new Flight(103, "Delhi-Chandigarh", 80, 3000));

        System.out.println("Available Flights: ");
        displayFlights(flights);

        // book seats
        bookTickets(flights, 101, 10);

        // cancel tickets
        cancelTickets(flights, 101, 2);

        //show updated flight details
        System.out.println("Updated flight details: ");
        displayFlights(flights);

        // cal. revenue
        calculateRevenue(flights);
        
    }

    // display all flights
    public static void displayFlights(ArrayList<Flight> flights) {
        for(Flight flight: flights) {
            flight.display();
        }
    }

    // to book tickets
    public static void bookTickets(ArrayList<Flight> flights, int flightId, int seatsNeeded) {
        
        // searching flight using flightid
        for(Flight flight: flights) {
            
            if(flight.flightId == flightId) {
                
                // check to find if enough seats are present
                if ((flight.totalSeats - flight.bookedSeats) >= seatsNeeded) {
                    
                    // increase count of booked seats
                    flight.bookedSeats += seatsNeeded;
                    System.out.println(seatsNeeded + " seats booked!");

                } else {
                    System.out.println("Seats not available.");
                }
                return;
            }
        }
        System.out.println("Flight not found.");
    }

    // to cancel booked tickets
    public static void cancelTickets(ArrayList<Flight> flights, int flightId, int seatsToCancel) {
        // search using flight id
        for(Flight flight: flights) {
            
            if(flight.flightId == flightId){
                
                // check whether enough seats are booked or not
                if(flight.bookedSeats >= seatsToCancel) {

                    // reduce booked seats
                    flight.bookedSeats -= seatsToCancel;
                    System.out.println(seatsToCancel + " Seats cancelled successfully.");

                } else {
                    System.out.println("Invalid cancellation request.");
                }
                return;
            }
        }
        System.out.println("Flight not found.");
    }

    // to calculate total revenue
    public static void calculateRevenue(ArrayList<Flight> flights) {
        double totalRevenue = 0;
        
        //add revenue from each flight
        for(Flight flight: flights) {
            totalRevenue += flight.bookedSeats * flight.ticketPrice;
        }

        System.out.println("Total Revenue: Rs. " + totalRevenue);
    }


}
