package interfaceextends.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    public void testCreatePoint() {
        //Given
        Point point = new Point(5, 10, 15);
        //Then
        assertEquals(5L, point.getX());
        assertEquals(10L, point.getY());
        assertEquals(15L, point.getZ());
    }

}