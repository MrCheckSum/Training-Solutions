package filescanner.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibraryTest {
    @Test
    public void testLoadFromFile() {
        Library library = new Library();
        library.loadFromFile();

        Assertions.assertEquals(4, library.getBooks().size());
        Assertions.assertEquals("Robert C. Martin", library.getBooks().get(2).getAuthor());
    }
}
