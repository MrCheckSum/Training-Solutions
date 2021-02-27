package inheritanceattributes.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void constructorTest() {
        //Given
        Book book = new Book("Naiv Super", 2000);
        //Then
        assertEquals("Naiv Super",book.getTitle());
        assertEquals(2000,book.price);
    }

    @Test
    public void testPurchase() {
        //Given
        Book book = new Book("Naiv Super", 2000);
        //Then
        assertEquals(4000,book.purchase(2));
    }


}