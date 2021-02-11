package week14d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createStudent() {
        Student student = new Student("Jack");
        assertEquals("Jack", student.getName());
    }

    @Test
    void addNote() {
        Student student = new Student("John");
        assertEquals(0, student.getNotes().size());

        student.addNote("physics", 4);
        assertEquals(1, student.getNotes().size());

        student.addNote("physics", 5);
        assertEquals(1, student.getNotes().size()); // méretének nem szabad változnia

        student.addNote("math", 5);
        assertEquals(2, student.getNotes().size());

    }
    @Test
    void getNotes() {
        Student student = new Student("John");
        student.addNote("physics", 4);
        student.addNote("math", 3);
        student.addNote("math", 5);

        assertEquals(5, student.getNotes().get("math").get(1));
        assertEquals(4, student.getNotes().get("physics").get(0));
    }

    @Test
    void compareTo() {
    }
}