package immutable.satellite;

import org.junit.jupiter.api.Test;
import xtest.C;

import static org.junit.jupiter.api.Assertions.*;

class SatelliteTest {

    @Test
    void testModifyDestination() {
        //Given
        Satellite satellite = new Satellite(new CelestialCoordinates(10,20,30),"ABC123");
        //When
        satellite.modifyDestination(new CelestialCoordinates(3,3,3));
        //Then
        assertEquals("ABC123: CelestialCoordinates > x:13, y:23, z:33", satellite.toString());
    }

    @Test
    public void testEmptyParameterShouldThrowExpectation() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> new Satellite(new CelestialCoordinates(10,20,30), ""));
        assertEquals("registerIdent is empty!", exception.getMessage());
    }
}