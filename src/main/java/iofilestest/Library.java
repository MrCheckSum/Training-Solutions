package iofilestest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void add(Book... books2) {
        boolean checkBook = false;
        for (Book addedBook : books2) {
            for (Book bookInTheList : books) {
                if (addedBook.getAuthor().equals(bookInTheList.getAuthor()) && addedBook.getTitle().equals(bookInTheList.getTitle())) {
                    checkBook = true;
                }
            }
            if (checkBook == false) {
                books.add(addedBook);
            }
        }
    }

    public void saveBooks(Path path) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Book book : books) {
                bufferedWriter.write(book.getAuthor());
                bufferedWriter.write("-");
                bufferedWriter.write(book.getTitle());
                bufferedWriter.write("\n");
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-writeable!", ioException);
        }
    }

    public void loadBooks(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split("-");
                add(new Book(temp[0], temp[1]));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }
}
