package week13d02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class AirlinesTest {

    Airlines airlines = new Airlines();
    Path file = Path.of("src/main/resources/cities.txt");

    @Test
    void getFlights() {
        airlines.readFile(file);
        assertEquals(100, airlines.getFlights().size());
    }

    @Test
    void readFile() {
        airlines.readFile(file);
        assertEquals(100, airlines.getFlights().size());
    }

    @Test
    void countStatusToGetBiggerType() {
        airlines.readFile(file);
        assertEquals(54, airlines.countStatusToGetBiggerType());
    }

    @Test
    void getDetailsOfFlight() {
        airlines.readFile(file);
        assertEquals("[ST9547, Arrival, Wien, 07:42]", airlines.getDetailsOfFlight("ST9547").toString());
    }

    @Test
    void findFlightByCityAndStatus() {
        airlines.readFile(file);
        assertEquals("[[ST9547, Arrival, Wien, 07:42]]", airlines.findFlightByCityAndStatus("Wien", "Arrival").toString());
    }

    @Test
    void getEarliestDepartureFlight() {
        airlines.readFile(file);
        assertEquals("[FG3210, Departure, Zurich, 06:16]", airlines.getEarliestDepartureFlight().toString());
    }
}