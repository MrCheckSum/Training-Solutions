package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private Set<Book> libraryBooks = new HashSet<>();

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) throws MissingBookException {

        Book foundBook;
        Iterator<Book> iterator = libraryBooks.iterator();

        while (iterator.hasNext()) {
            foundBook = iterator.next();
            if (foundBook.getRegNumber() == regNumber) {
                return foundBook;
            }
        }
        throw new MissingBookException("No book found!");
    }

    public int removeBookByRegNumber(int regNumber) throws MissingBookException {
        Book foundBook;
        Iterator<Book> iterator = libraryBooks.iterator();

        while (iterator.hasNext()) {
            foundBook = iterator.next();
            if (foundBook.getRegNumber() == regNumber) {
                iterator.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No book found!");
    }

    public Set<Book> selectBooksByAuthor(String author) throws MissingBookException {
        Set<Book> authorBooks = new HashSet<>();

        Book foundBook;
        Iterator<Book> iterator = libraryBooks.iterator();

        while (iterator.hasNext()) {
            foundBook = iterator.next();
            if (foundBook.getAuthor() == author) {
                authorBooks.add(foundBook);
            }
        }
        if (authorBooks.isEmpty()) {
            throw new MissingBookException("No book found!");
        }
        return authorBooks;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}
