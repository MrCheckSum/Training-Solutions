package week07d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LabTest {

    @Test
    void testConstructor () {
        Lab lab = new Lab("Egri Csillagok");

        Assertions.assertEquals("Egri Csillagok", lab.getTitle());
        Assertions.assertFalse(lab.isCompleted());
        Assertions.assertEquals(null,lab.getCompletedAt());

    }
    @Test
    void testConstructor2 () {
        Lab lab = new Lab("Egri Csillagok", LocalDate.of(2020,10,11));

        Assertions.assertEquals("Egri Csillagok", lab.getTitle());
        Assertions.assertTrue(lab.isCompleted());
        Assertions.assertEquals(LocalDate.of(2020,10,11),lab.getCompletedAt());

    }

    @Test
    void testComplete() {
        Lab lab = new Lab("Egri Csillagok");
        lab.complete();

        Assertions.assertTrue(lab.isCompleted());
        Assertions.assertEquals(LocalDate.now(),lab.getCompletedAt());
    }

}
