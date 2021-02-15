package collectionsiterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest {

    private LibraryManager manager;

    @BeforeEach
    void setUp() {

        Set<Book> bookSet = new HashSet<>(Arrays.asList(new Book(1245, "Core Java", "Cay Horstmann"),
                new Book(2454, "Core JavaServer Faces", "Cay Horstmann"),
                new Book(5454, "Effective Java", "Bloch")));
        manager = new LibraryManager(bookSet);
    }

    @Test
    void findBookByRegNumber() throws MissingBookException {

        Book book = manager.findBookByRegNumber(1245);

        assertEquals("Cay Horstmann", book.getAuthor());
        assertEquals("Core Java", book.getTitle());

    }

    @Test
    void removeBookByRegNumber() throws MissingBookException {

        int removedBookId = manager.removeBookByRegNumber(2454);
        assertEquals(2454, removedBookId);
        assertEquals(2, manager.libraryBooksCount());

    }

    @Test
    void selectBooksByAuthor() throws MissingBookException {

        Set<Book> foundBooks = manager.selectBooksByAuthor("Cay Horstmann");

        assertEquals(2, foundBooks.size());

    }
}