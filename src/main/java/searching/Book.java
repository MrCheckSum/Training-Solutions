package searching;

public class Book implements Comparable<Book> {

    private int id;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book> " + id + ":" + author + ":" + title;
    }

    @Override
    public int compareTo(Book o) {
        if (author.compareTo(o.author) != 0) {
            return author.compareTo(o.author);
        } else {
            return title.compareTo(o.title);
        }
    }
}
