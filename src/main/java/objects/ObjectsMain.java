package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {
    public static void main(String[] args) {
        //Objektumok
        System.out.println(new Book());

        Book emptyBook = new Book();
        System.out.println(emptyBook);

        emptyBook = null;
        System.out.println(emptyBook);

        System.out.println(emptyBook == null);

        Book book = new Book();
        book = null;
        Book anotherBook = new Book();
        anotherBook = book;

        System.out.println(book == anotherBook);

        System.out.println(book instanceof Book);

        // Objektumok száma
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;
        book4 = book5;
        book5 = new Book();
        book6 = null;
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
        System.out.println(book5);
        System.out.println(book6); //hozzá lehet férni
        System.out.println(book7); //hozzá lehet férni
        // összesen 6 objektum jön létre 4 new-al és 2 null-al, book4 ref a book1-re

        //Tömbök és kollekciók
        Book[] books = {new Book(), new Book(), new Book()};

        List<Book> books1 = Arrays.asList(new Book(), new Book(), new Book());

        List<Book> books2 = new ArrayList<>();
        books2.add(new Book());
        books2.add(new Book());
        books2.add(new Book());


    }

}
