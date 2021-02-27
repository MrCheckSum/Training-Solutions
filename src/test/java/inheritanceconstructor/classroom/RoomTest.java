package inheritanceconstructor.classroom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void constructorTest() {
        //Given
        Room room = new Room("II. em. 20.", 20);
        //Then
        assertEquals("II. em. 20.", room.getLocation());
        assertEquals(20, room.getCapacity());
    }

}