package searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookArraySearchTest {

    private List<Book> bookList = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("books2.csv");
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(";");
                bookList.add(new Book(Integer.parseInt(lineParts[0]), lineParts[2], lineParts[1]));
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("File not found");
        }
            }


    @Test
    public void emptyParametersShouldThrowException() throws IllegalArgumentException {

        Book[] bookArray = new Book[bookList.size()];

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new BookArraySearch(bookList.toArray(bookArray)).findBookByAuthorTitle("", ""));
        assertEquals("Author or title is must to be given!", ex.getMessage());

    }

    @Test
    public void emptyParametersShouldThrowExceptionNull() throws IllegalArgumentException {

        Book[] bookArray = new Book[bookList.size()];

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new BookArraySearch(bookList.toArray(bookArray)).findBookByAuthorTitle(null, null);
        });
        assertEquals("Author or title is must to be given!", ex.getMessage());

    }

    @Test
    public void notFoundBookShouldThrowException() throws IllegalArgumentException {

        String author = "Homérosz";
        String title = "Iliász";
        Book[] bookArray = new Book[bookList.size()];

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new BookArraySearch(bookList.toArray(bookArray)).findBookByAuthorTitle(title, author);
        });
        assertEquals("No book was found >> Author: " + author + ":" + "Title: " + title, ex.getMessage());

    }

    @Test
    public void testFindBookByAuthorTitle() {
        //Given
        Book[] bookArray = new Book[bookList.size()];
        BookArraySearch bas = new BookArraySearch(bookList.toArray(bookArray));
        //When
        String author = "Fazekas Anna";
        String title = "Mackó, mókus, malacka";
        Book book = bas.findBookByAuthorTitle(title ,author);
        //Then
        assertEquals(1010, book.getId());
        assertEquals("Fazekas Anna", book.getAuthor());
        assertEquals("Mackó, mókus, malacka", book.getTitle());
        assertEquals("Book> 1010:Fazekas Anna:Mackó, mókus, malacka", book.toString());
    }
}