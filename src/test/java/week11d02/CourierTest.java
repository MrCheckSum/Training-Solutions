package week11d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    void addFirstRide() {
        List<Ride> list = new ArrayList<>();
        Courier courier = new Courier(list);
        Ride ride = new Ride(1, 1, 1);
        courier.addRide(ride);
        assertEquals(1, courier.getRides().size());
    }

    @Test
    void freeDay() {
        Courier courier = new Courier(List.of(
                new Ride(1, 1, 1),
                new Ride(1, 2, 3),
                new Ride(3, 1, 1)));
        assertEquals(2, courier.getEarliestHoliday());
    }
}