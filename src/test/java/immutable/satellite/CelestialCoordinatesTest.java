package immutable.satellite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CelestialCoordinatesTest {

    @Test
    void testToString() {

        assertEquals("CelestialCoordinates > x:10, y:20, z:30",new CelestialCoordinates(10,20,30).toString());
    }
}