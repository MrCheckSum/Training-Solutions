package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides = new ArrayList<>();

    public Courier(List<Ride> rides) {
        this.rides = rides;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride ride) {
        if (ride == null) {
            throw new IllegalArgumentException("No ride");
        }
        if (rides.size() < 1) {
            if (ride.getRide() == 1) {
                rides.add(ride);
                return;
            } else {
                throw new IllegalArgumentException("Not the first ride");
            }

        } else {
            if (rides.get(rides.size() - 1).getDay() > ride.getDay()) {
                throw new IllegalArgumentException("Invalid day number");
            }
            if (rides.get(rides.size() - 1).getDay() < ride.getDay() && ride.getRide() == 1) {
                rides.add(ride);
                return;
            }
            if (rides.get(rides.size() - 1).getDay() == ride.getDay() && rides.get(rides.size() - 1).getDay() + 1 == ride.getRide()) {
                rides.add(ride);
                return;
            }

            throw new IllegalArgumentException("Invalid ride number");

        }

    }

    public int getEarliestHoliday() {
        int hd = 0;
        for (int i = 1; i <= 7; i++) {
            for (Ride ride : rides) {
                if (i == ride.getDay()) {
                    hd++;
                }
            }
            if (hd == 0) {
                return i;
            }
            hd = 0;
        }
        return -1;

    }
}