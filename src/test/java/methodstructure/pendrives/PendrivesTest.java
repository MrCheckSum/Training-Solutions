package methodstructure.pendrives;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PendrivesTest {

    private static final List<Pendrive> PENDRIVE_LIST = Arrays.asList(
            new Pendrive("PD1", 32, 1000),
            new Pendrive("PD2", 64, 1999),
            new Pendrive("PD3", 32, 1100),
            new Pendrive("PD4", 64, 2000));

    @Test
    void bestpricepercapacity() {

        Pendrives pendrives = new Pendrives();
        assertEquals(PENDRIVE_LIST.get(1), pendrives.bestpricepercapacity(PENDRIVE_LIST));

    }

    @Test
    void cheapestbyprice() {

        Pendrives pendrives = new Pendrives();
        assertEquals(PENDRIVE_LIST.get(0), pendrives.cheapestbyprice(PENDRIVE_LIST));

    }

    @Test
    void risePriceWhereCapacity() {

        Pendrives pendrives = new Pendrives();

        int[] expectedrisedprise = {1200, 1999, 1320, 2000};
        pendrives.risePriceWhereCapacity(PENDRIVE_LIST, 20, 32);
        for (int i = 0; i < PENDRIVE_LIST.size(); i++) {
            assertEquals(expectedrisedprise[i], PENDRIVE_LIST.get(i).getPrice());
        }


    }


}