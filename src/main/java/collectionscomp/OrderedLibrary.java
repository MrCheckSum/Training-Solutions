package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    private List<Book> libraryBooks = new LinkedList<>();

    public OrderedLibrary(List<Book> libraryBooks) {
        if (libraryBooks == null || libraryBooks.isEmpty()) {
            throw new IllegalArgumentException("Booklist is empty!");
        }
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByAuthor() {
        List<Book> oList = new ArrayList<>(libraryBooks);
        Collections.sort(oList, new AuthorComparator());
        return oList;
    }

    public List<Book> orderedByTitle() {
        List<Book> oList = new ArrayList<>(libraryBooks);
        Collections.sort(oList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return oList;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> result = new ArrayList<>(libraryBooks.size());
        for (Book book : libraryBooks) {
            result.add(book.getTitle());
        }
        Collections.sort(result, Collator.getInstance(locale));
        return Collections.unmodifiableList(result);

        /*
        vagy
        List<String> orderedList = new ArrayList<>();
        for (Book book : libraryBooks) {
            orderedList.add(book.getTitle());
        }
        Collator hungarianCollator = Collator.getInstance(locale);
        hungarianCollator.setStrength(Collator.PRIMARY);
        Collections.sort(orderedList, hungarianCollator);

        return orderedList;
         */


    }


}
