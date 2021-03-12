package schoolrecords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ClassRecordsTest {

    private ClassRecords classRecords;
    private Tutor tutor = new Tutor("Tutor1",
            Arrays.asList(new Subject("Subject1"),
                    new Subject("Subject2"),
                    new Subject("Subject3"),
                    new Subject("Subject4"),
                    new Subject("Subject5"),
                    new Subject("Subject6")));


    @BeforeEach
    public void setUp() {
        classRecords = new ClassRecords("Fourth Grade A", new Random(5));
        Student firstStudent = new Student("Student1");
        Student secondStudent = new Student("Student2");
        Student thirdStudent = new Student("Student3");
        Student fourthStudent = new Student("Student4");
        firstStudent.grading(new Mark(MarkType.A, new Subject("Subject1"), tutor));
        firstStudent.grading(new Mark(MarkType.C, new Subject("Subject2"), tutor));
        firstStudent.grading(new Mark(MarkType.D, new Subject("Subject1"), tutor));
        secondStudent.grading(new Mark(MarkType.A, new Subject("Subject3"), tutor));
        secondStudent.grading(new Mark(MarkType.C, new Subject("Subject2"), tutor));
        secondStudent.grading(new Mark(MarkType.D, new Subject("Subject4"), tutor));
        thirdStudent.grading(new Mark(MarkType.A, new Subject("Subject5"), tutor));
        thirdStudent.grading(new Mark(MarkType.C, new Subject("Subject6"), tutor));
        thirdStudent.grading(new Mark(MarkType.D, new Subject("Subject1"), tutor));
        classRecords.addStudent(firstStudent);
        classRecords.addStudent(secondStudent);
        classRecords.addStudent(thirdStudent);
    }

    @Test
    public void testCreate() {
        assertEquals("Fourth Grade A", classRecords.getClassName());
    }

    @Test
    public void testAddStudentAlreadyExists() {
        assertFalse(classRecords.addStudent(new Student("Student2")));
    }

    @Test
    public void testAddStudent() {
        assertTrue(classRecords.addStudent(new Student("Student5")));
    }

    @Test
    public void testRemoveStudent() {
        assertTrue(classRecords.removeStudent(new Student("Student2")));
    }

    @Test
    public void testRemoveStudentDoesNotExists() {
        assertFalse(classRecords.removeStudent(new Student("Student5")));
    }

    @Test
    public void emptyStudentListShouldThrowException() throws ArithmeticException {

        Exception ex = assertThrows(ArithmeticException.class, () -> new ClassRecords("First Grade", new Random()).calculateClassAverage());
        assertEquals("No students in the class!", ex.getMessage());

    }

    @Test
    public void noMarksShouldThrowException() throws ArithmeticException {


        ClassRecords classRecords = new ClassRecords("First Grade", new Random());
        classRecords.addStudent(new Student("Student2"));


        Exception ex = assertThrows(ArithmeticException.class, () -> classRecords.calculateClassAverage());
        assertEquals("No marks presented yet!", ex.getMessage());
    }

    @Test
    public void testCalculateClassAverage() {
        assertEquals(3.33, classRecords.calculateClassAverage());
    }

    @Test
    public void testCalculateClassAverageBySubject() {
        //Given
        Subject geography = new Subject("Subject1");
        //Then
        assertEquals(2.75, classRecords.calculateClassAverageBySubject(geography));
    }

    @Test
    public void emptyStudentNameShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> classRecords.findStudentByName(""));
        assertEquals("Student name must be filled in!", ex.getMessage());
    }

    @Test
    public void emptyListShouldThrowException() throws IllegalStateException {
        Exception ex = assertThrows(IllegalStateException.class, () -> new ClassRecords("First Grade", new Random()).findStudentByName("Student1"));
        assertEquals("There are no students in any class!", ex.getMessage());
    }

    @Test
    public void nonExistingStudentShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> classRecords.findStudentByName("Student6"));
        assertEquals("Student not found! Student6", ex.getMessage());
    }

    @Test
    public void testFindStudentByName() {
        assertEquals("Student1", classRecords.findStudentByName("Student1").getName());
    }

    @Test
    public void emptyListException() throws IllegalStateException {
        Exception ex = assertThrows(IllegalStateException.class, () -> new ClassRecords("Fourth Grade", new Random()).repetition());
        assertEquals("No students to select for repetition!", ex.getMessage());
    }

    @Test
    public void testRepetition() {
        assertEquals("Student3", classRecords.repetition().getName());
    }

    @Test
    public void testListStudyResults() {
        //Given
        List<StudyResultByName> list = classRecords.listStudyResults();
        //Then
        assertEquals("Student1", list.get(0).getStudentName());
        assertEquals(3.33, list.get(0).getStudyAverage());
        assertEquals(3, list.size());
    }

    @Test
    public void testListStudentNames() {
        assertEquals("Student1, Student2, Student3", classRecords.listStudentNames());
    }
}