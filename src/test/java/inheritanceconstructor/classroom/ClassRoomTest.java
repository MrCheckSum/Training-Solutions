package inheritanceconstructor.classroom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassRoomTest {

    @Test
    public void constructorTest() {
        //Given
        ClassRoom classroom = new ClassRoom("100", 20, Facility.CHALKBOARD);
        //Then
        assertEquals("100", classroom.getLocation());
        assertEquals(20, classroom.getCapacity());
        assertEquals(Facility.CHALKBOARD, classroom.getFacility());
    }

    @Test
    public void isSuitableSuccess() {
        //Given
        ClassRoom classroom = new ClassRoom("100", 20, Facility.COMPUTERS);
        Course course = new Course(12, Facility.COMPUTERS);
        //Then
        assertTrue(classroom.isSuitable(course));

    }

    @Test
    public void isSuitableFail() {
        //Given
        ClassRoom classroom = new ClassRoom("100", 20, Facility.COMPUTERS);
        Course course = new Course(16, Facility.CHALKBOARD);
        //Then
        assertFalse(classroom.isSuitable(course));
    }


}