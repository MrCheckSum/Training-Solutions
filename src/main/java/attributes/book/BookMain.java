package attributes.book;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("El Mariachi");
        System.out.println(book.getTitle());

        book.setTitle("El Sombrero");
        System.out.println(book.getTitle());
    }
}
