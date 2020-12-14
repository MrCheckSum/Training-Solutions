package week07d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehicleTest {

    @Test
    public void testVehicles() {

        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Motorcycle motorcycle = new Motorcycle();
        Truck truck = new Truck();

        Assertions.assertEquals(5, vehicle.getNumberOfGears());
        Assertions.assertEquals(5, car.getNumberOfGears());
        Assertions.assertEquals(5, motorcycle.getNumberOfGears());
        Assertions.assertEquals(5, truck.getNumberOfGears());

        Assertions.assertEquals(TransmissionType.MANUAL, vehicle.getTransmissionType());
        Assertions.assertEquals(TransmissionType.AUTOMATIC, car.getTransmissionType());
        Assertions.assertEquals(TransmissionType.SEQUENTIAL, motorcycle.getTransmissionType());
        Assertions.assertEquals(TransmissionType.MANUAL, truck.getTransmissionType());

    }
}
