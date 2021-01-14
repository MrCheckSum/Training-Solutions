package methodoverloading.pub;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PubTest {

    @Test
    public void testConstructor(){

        //Given
        Pub pub = new Pub("Kocsma 1", 6, 0);

        //Then
        assertEquals(6, pub.getOpenFrom().getHours());
        assertEquals(0, pub.getOpenFrom().getMinutes());
    }


    @Test
    void testToString() {

        //Given
        Pub pub = new Pub("Kocsma 1", 6, 0);

        //Then
        assertEquals("Kocsma 1 >> 6:0", pub.toString());
    }
}