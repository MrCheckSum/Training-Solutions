package methodstructure.pendrives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PendriveTest {

    @Test
    void cheaperThan() {

        Pendrive pendrive1 = new Pendrive("PD1", 32, 1000);
        Pendrive pendrive2 = new Pendrive("PD2", 64, 1999);
        Pendrive pendrive3 = new Pendrive("PD3", 32, 1100);
        Pendrive pendrive4 = new Pendrive("PD4", 64, 2000);

        assertTrue(pendrive1.cheaperThan(pendrive2));
        assertFalse(pendrive4.cheaperThan(pendrive1));
    }

    @Test
    void comparePricePerCapacity() {

        Pendrive pendrive1 = new Pendrive("PD1", 32, 1000);
        Pendrive pendrive2 = new Pendrive("PD2", 64, 1999);
        Pendrive pendrive3 = new Pendrive("PD3", 32, 1100);
        Pendrive pendrive4 = new Pendrive("PD4", 64, 2000);

        assertEquals(1, pendrive1.comparePricePerCapacity(pendrive2));
        assertEquals(-1, pendrive1.comparePricePerCapacity(pendrive3));
        assertEquals(0, pendrive1.comparePricePerCapacity(pendrive4));
        assertEquals(1, pendrive1.comparePricePerCapacity(pendrive2));
    }

    @Test
    void risePriceWhereCapacity() {
        Pendrive pendrive = new Pendrive("PD1", 32, 1000);
        pendrive.risePrice(20);
        assertEquals(1200, pendrive.getPrice());
    }
}