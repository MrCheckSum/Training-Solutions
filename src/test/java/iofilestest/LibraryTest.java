package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @TempDir
    Path tempDir;

    @Test
    void add() {
        Book one = new Book("A1", "T1");
        Book two = new Book("A2", "T2");

        Library library = new Library();
        library.add(one);
        library.add(two);

        library.add(new Book("A2", "T2"));
        assertEquals(3, library.getBooks().size());
    }

    @Test
    void saveBooks() throws IOException {
        Book one = new Book("A1", "T1");
        Book two = new Book("A2", "T2");

        Library library = new Library();
        library.add(one);
        library.add(two);

        Path path = tempDir.resolve("test.txt");
        library.saveBooks(path);
  //      List<Book> testBooks = library.loadBooks(path);
        assertTrue(Files.exists(path));

        DataInputStream input = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)));
        assertEquals("A1", input.readUTF());
        assertEquals("T1", input.readUTF());

    }

    @Test
    void loadBooks() throws IOException {

        Path path = tempDir.resolve("test.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)));
        dataOutputStream.writeUTF("A1");
        dataOutputStream.writeUTF("T1");
        dataOutputStream.writeUTF("A2");
        dataOutputStream.writeUTF("T2");
        dataOutputStream.close();

        Library library = new Library();
        library.loadBooks(path);
        System.out.println(library.toString());

        assertEquals(2, library.getBooks().size());
        assertEquals("A2", library.getBooks().get(1).getAuthor());
        assertEquals("T2", library.getBooks().get(1).getTitle());


    }
}