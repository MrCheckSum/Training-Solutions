package methodoverloading.pub;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListOfGoodPubsTest {

    @Test
    public void testThrowExeptionWhenPubListIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ListOfGoodPubs(new ArrayList<>()));
        assertEquals("Pub list can not be empty!", exception.getMessage());

    }

    @Test
    public void findTheBestPub() {

        ListOfGoodPubs listOfGoodPubs = new ListOfGoodPubs(Arrays.asList(
                new Pub("Kocsma 1", 6, 0),
                new Pub("Kocsma 2", 7, 0),
                new Pub("Kocsma 3", 8, 0),
                new Pub("Kocsma 4", 9, 0),
                new Pub("Kocsma 5", 5, 0)
        ));

        assertEquals("Kocsma 5 >> 5:0", listOfGoodPubs.findTheBestPub().toString());
    }
}