package week13d02;
/*
Adott egy fájl melyben egy reptér egy napi munkáját rögzítettük. Adott egy járatszám, az, hogy érkező vagy felszálló gépről van-e szó.
A kiinduló/cél város, attól függöen hogy indul vagy érkezik-e a gép és a felszállás/leszállás pontos ideje.

A fájl:
FC5354 Arrival Dublin 18:16
KH2442 Departure Berlin 15:54
ID4963 Departure Amsterdam 15:22
CX8486 Arrival Brussels 10:37
EJ9251 Departure  Toronto 11:30
KJ7245 Departure Bern 6:18
JN6048 Arrival Moscow 18:39
MN5047 Arrival Athens 9:35

Az időpontok szándékosan így szereplnek, nincsenek nullák a számok előtt. Az adatok össze vissza szerepelnek a fájlban.
Feladatok:
1. Olvasd be a fájl tartalmát a memóriába.
2. Határozd meg, hogy induló vagy érkező járatból volt-e több.
3. Legyen egy metódus ami járatszám alapján ad vissza egy repülőt.
4. Írj egy metódust ami bekér egy várost és azt, hogy az induló vagy érkező járatokat szeretnénk-e.
És egy Listába adjuk viassza az összes abba városba induló/érkező repülőt.
5. Adjuk vissza a legkorábban induló repülőt!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airlines {

    private List<Flights> flights = new ArrayList<>();

    public List<Flights> getFlights() {
        return flights;
    }

    public void readFile(Path filePathInString) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePathInString)) {
            //flights.clear();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                String flightId = parts[0];
                String status = parts[1];
                String city = parts[2];
                String[] timeParts = parts[3].split(":");
                LocalTime time = LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));

                flights.add(new Flights(flightId, status, city, time));

            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }

    public int countStatusToGetBiggerType() {

        int arrival = 0;
        int departure = 0;

        for (Flights flight : flights) {
            if (flight.getStatus().equals("Arrival")) {
                arrival++;
            } else {
                departure++;
            }
        }
        return arrival > departure ? arrival : departure;
    }

    public Flights getDetailsOfFlight(String flightId) {
        for (Flights flight : flights) {
            if (flight.getFlightId().equals(flightId)) {
                return flight;
            }
        }
        throw new IllegalArgumentException("There is no flight with ID: " + flightId);
    }

    public List<Flights> findFlightByCityAndStatus(String city, String arrivalOrDeparture) {
        List<Flights> result = new ArrayList<>();
        for (Flights flight : flights) {
            if (flight.getCity().equals(city) && flight.getStatus().equals(arrivalOrDeparture)) {
                result.add(flight);
            }
        }
        if (result.size() == 0) {
            throw new IllegalArgumentException("There is no flight with city: " + city + " and status:" + arrivalOrDeparture);
        }
        return result;
    }

    public Flights getEarliestDepartureFlight() {
        LocalTime time = LocalTime.of(23,59,59);//vagy létrehozunk egy üres járatot ezzel a time-al
        Flights earliestFlight = flights.get(0);
        for (Flights flight : flights) {
            if (flight.getTime().isBefore(earliestFlight.getTime()) && flight.getStatus().equals("Departure")) {
                earliestFlight = flight;
            }
        }
        return earliestFlight;
    }

    public static void main(String[] args) {
        Path path = Path.of("src/main/resources/cities.txt");
        Airlines airlines = new Airlines();
        airlines.readFile(path);
        System.out.println(airlines.getFlights());
        System.out.println(airlines.getEarliestDepartureFlight());
        System.out.println(airlines.countStatusToGetBiggerType());
        System.out.println(airlines.getDetailsOfFlight("KX8489"));
        System.out.println(airlines.findFlightByCityAndStatus("Budapest", "Arrival"));

    }
}
