package arrayList;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> booksTitles = new ArrayList<>();

    public void booksAddTitle(String title) {
        booksTitles.add(title);
    }

    public void booksDeleteByPrefix(String prefix) {
        List<String> toDelByPrefix = new ArrayList<>();
        for (String book : booksTitles) {
            if (book.startsWith(prefix)) {
                toDelByPrefix.add(book);
            }
        }
        booksTitles.removeAll(toDelByPrefix);
    }

    public List<String> booksFindAllByPrefix(String prefix) {
        List<String> toFindAllByPrefix = new ArrayList<>();
        for (String book : booksTitles) {
            if (book.startsWith(prefix)) {
                toFindAllByPrefix.add(book);
            }
        }
        return toFindAllByPrefix;
    }

    public List<String> getBooksTitles() {
        return booksTitles;
    }

    public static void main(String[] args) {
        Books books = new Books();

        books.booksAddTitle("Book 1");
        books.booksAddTitle("NoteBook 1");
        books.booksAddTitle("Book 2");
        books.booksAddTitle("NoteBook 2");
        books.booksAddTitle("Bible 1");

        System.out.println(books.getBooksTitles());

        System.out.println(books.booksFindAllByPrefix("Note"));

        books.booksDeleteByPrefix("Book");
        System.out.println(books.getBooksTitles());


    }

}
