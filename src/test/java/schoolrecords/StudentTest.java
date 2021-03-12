package schoolrecords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    public static final Subject SUBJECT = new Subject("Subject1");
    public static final Tutor TUTOR = new Tutor("Tutor1", Arrays.asList(SUBJECT, new Subject("Subject2")));


    @Test
    public void emptyNameShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Student(""));
        assertEquals("Student name is empty!", ex.getMessage());
    }

    @Test
    public void nullMarkInGradingShouldThrowException() throws NullPointerException {

        Exception ex = assertThrows(NullPointerException.class, () -> new Student("Student1").grading(null));
        assertEquals("Mark can not be null!", ex.getMessage());
    }

    @Test
    public void testGrading() {
        //Given
        Student student = new Student("Student1");
        //When
        student.grading(new Mark(MarkType.A, SUBJECT, TUTOR));
        //Then
        assertEquals("Student1 marks: Subject1: excellent(5)", student.toString());
    }

    @Test
    public void testCalculateAverage() {
        //Given
        Student student = new Student("Student1");
        //When
        student.grading(new Mark(MarkType.A, SUBJECT, TUTOR));
        student.grading(new Mark(MarkType.C, SUBJECT, TUTOR));
        student.grading(new Mark(MarkType.D, SUBJECT, TUTOR));
        //Then
        assertEquals(3.33, student.calculateAverage());
    }

    @Test
    public void testCalculateAverageIfMarksEmpty() {
        //Given
        Student student = new Student("Student1");
        //Then
        assertEquals(0.0, student.calculateAverage());
    }


    @Test
    public void testCalculateSubjectAverage() {
        //Given
        Student student = new Student("Student1");
        //When
        student.grading(new Mark(MarkType.A, SUBJECT, TUTOR));
        student.grading(new Mark(MarkType.C, new Subject("Subject2"), TUTOR));
        student.grading(new Mark(MarkType.D, SUBJECT, TUTOR));
        //Then
        assertEquals(3.50, student.calculateSubjectAverage(SUBJECT));
    }

    @Test
    public void testCalculateSubjectAverageIfMarksEmpty() {
        //Given
        Student student = new Student("Student1");
        //Then
        assertEquals(0.0, student.calculateSubjectAverage(SUBJECT));
    }

    @Test
    public void testCalculateSubjectAverageIfNoMarkFromSubject() {
        //Given
        Student student = new Student("Student1");
        //When
        student.grading(new Mark(MarkType.A, SUBJECT, TUTOR));
        student.grading(new Mark(MarkType.C, new Subject("Subject2"), TUTOR));
        student.grading(new Mark(MarkType.D, SUBJECT, TUTOR));
        //Then
        assertEquals(0.0, student.calculateSubjectAverage(new Subject("Subject3")));
    }

}