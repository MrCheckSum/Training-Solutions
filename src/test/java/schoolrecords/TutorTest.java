package schoolrecords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TutorTest {

    @Test
    public void testTutorTeachingSubject() {
        //Given
        Tutor tutor = new Tutor("Tutor1", Arrays.asList(new Subject("Subject1"), new Subject("Subject2")));
        //Then

        assertEquals("Tutor1", tutor.getName());
        assertTrue(tutor.tutorTeachingSubject(new Subject("Subject2")));
    }

    @Test
    public void testTutorNotTeachingSubject() {
        //Given
        Tutor tutor = new Tutor("Tutor1", Arrays.asList(new Subject("Subject1"), new Subject("Subject2")));
        //Then

        assertFalse(tutor.tutorTeachingSubject(new Subject("Subject3")));
    }

}