package exam03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("Not enough space on the boat!");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {

        double fullPrice = 0.0;
        if (passenger.getCruiseClass() == CruiseClass.FIRST) {
            fullPrice = basicPrice * 1.0;
        }

        if (passenger.getCruiseClass() == CruiseClass.SECOND) {
            fullPrice = basicPrice * 1.8;
        } else {
            fullPrice = basicPrice * 3.0;
        }

        return fullPrice;
    }

    public Passenger findPassengerByName(String name) {

        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        throw new IllegalArgumentException("No passenger found!");
    }

    /*
    public Passenger findPassengerNameOrdered(String name) {
    return Passener
    }
     */

    /*
        public void getPassengerNamesOrdered() {
        return  List<String>
        }
    */

    public double sumAllBookingsCharged() {
        double allBookedCharge = 0.0;
        for (Passenger passenger : passengers) {
            allBookedCharge += getPriceForPassenger(passenger);
        }
        return allBookedCharge;
    }

    /*
    public Map<CruiseClass, Integer> countPassengerByClass() {
    return Map
    }
    */
}
