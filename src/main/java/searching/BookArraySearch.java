package searching;

import java.util.Arrays;

public class BookArraySearch {

    private Book[] bookArray;


    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String title, String author) {

        if (author.isEmpty() || author == null || title.isEmpty() || title == null) {
            throw new IllegalArgumentException("Author or title is must to be given!");
        }
        Book searchKey = new Book(title, author);
        Arrays.sort(bookArray);

        int idx = Arrays.binarySearch(bookArray, searchKey);
        if (idx < 0) {
            throw new IllegalArgumentException("No book was found >> Author: " + author + ":" + "Title: " + title);
        }
        return bookArray[idx];

    }

}
