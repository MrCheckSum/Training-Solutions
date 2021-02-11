package week14d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotesBookTest {

    @Test
    void getStudents() {
    }

    @Test
    void sortNoteBook() {
        ClassNotesBook classNotesBook = new ClassNotesBook(new ArrayList<>(List.of(new Student("Jane"), new Student("John"), new Student("Jack"), new Student("James"))));

        List<Student> sortedList = classNotesBook.sortNoteBook();

        assertEquals("Jane", classNotesBook.getStudents().get(0).getName());
        assertEquals("Jack", sortedList.get(0).getName());
        assertEquals("John", sortedList.get(3).getName());


        System.out.println(classNotesBook.getStudents().toString());
        System.out.println(sortedList.toString());
    }
}