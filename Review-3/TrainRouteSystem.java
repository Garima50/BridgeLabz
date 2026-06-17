
import java.util.LinkedList;

// class representing a station
class Station {
    int stationId;
    String stationName;
    double distanceFromSource;

    Station(int stationId, String stationName, double distanceFromSource) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.distanceFromSource = distanceFromSource;
    }

    // to display station details
    public void display() {
        System.out.println(stationId + ", " + stationName + ", Distance: " + distanceFromSource + " km");
    }
}

// main class for trainroute system
public class TrainRouteSystem {
    public static void main(String[] args) {
        // to maintain train route
        LinkedList<Station> route = new LinkedList<>();

        //add station at the start of the route
        route.addFirst(new Station(101, "Delhi", 0));

        // add stations at the end of route
        route.addLast(new Station(102, "Panipat", 90));
        route.addLast(new Station(103, "Kurukshetra", 160));

        // add a station in betweeen using index value
        route.add(2, new Station(104, "Karnal", 125));

        System.out.println("Complete route: ");
        displayRoute(route);

        //search station by name
        searchStation(route, "karnal");

        //find total route dis.
        findTotalDistance(route);

        //remove station from route
        removeStation(route, "Panipat");

        System.out.println("Updated route: ");
        displayRoute(route);

    }

    // display all stations in the route
    public static void displayRoute(LinkedList<Station> route) {
        for(Station station: route) {
            station.display();
        }
    }

    //to search station by name
    public static void searchStation(LinkedList<Station> route, String stationName) {

        for(Station station: route) {
            if(station.stationName.equalsIgnoreCase(stationName)) {
                System.out.println("Station Found: ");
                station.display();
                return;
            }
        }
        System.out.println("Station not found.");
    }

    // to find total route distance
    public static void findTotalDistance(LinkedList<Station> route) {
        double totalDistance = route.getLast().distanceFromSource; // last station contains total distanxe from source

        System.out.println("Total route distance: " + totalDistance + " km"); 
    }

    // to remove station by name
    public static void removeStation(LinkedList<Station> route, String stationName) {
        for(int i = 0; i < route.size(); i++) {
            
            //check if the station matches
            if(route.get(i).stationName.equalsIgnoreCase(stationName)) {
                // remove sttaion
                route.remove(i);
                System.out.println("Station removed.");
                return;
            }
        }
        System.out.println("Station not found.");
    }


}
