package inheritanceattributes.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippedBookTest {

    @Test
    public void constructorAndToStringTest() {
        //Given
        ShippedBook book = new ShippedBook("Naiv Super", 2000, 600);
        //Then
        assertEquals("Naiv Super:2000 - 600",book.toString());
    }

    @Test
    public void orderTest()  {
        //Given
        ShippedBook book = new ShippedBook("The Expanse", 4000, 2000);
        //Then
        assertEquals(14000,book.order(3));
    }


}