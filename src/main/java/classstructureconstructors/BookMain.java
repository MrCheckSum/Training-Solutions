package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book bookMain = new Book("Paulo Coelho", "Facebook bölcseletek mindenkinek");
        bookMain.register("1000");

        System.out.println(bookMain.getAuthor());
        System.out.println(bookMain.getTitle());
        System.out.println(bookMain.getRegNumber());
    }
}
