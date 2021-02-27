package inheritanceconstructor.classroom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    public void constructorTest() {
        //Given
        Course course = new Course(40, Facility.PROJECTOR);
        //Then
        assertEquals(40, course.getParticipants());
        assertEquals(Facility.PROJECTOR, course.getFacilityNeeded());
    }

}