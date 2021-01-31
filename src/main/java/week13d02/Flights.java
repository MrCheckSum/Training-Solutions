package week13d02;

import java.time.LocalTime;

public class Flights {

    private String flightId;
    private String status;
    private String city;
    private LocalTime time;

    public Flights(String flightId, String status, String city, LocalTime time) {
        this.flightId = flightId;
        this.status = status;
        this.city = city;
        this.time = time;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getStatus() {
        return status;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "["+flightId +", "+ status +", "+ city + ", " + time+"]";
    }
}
