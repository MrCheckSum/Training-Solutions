package introexception.patient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TajSzamValidatorTest {

    @Test
    public void testTajSzamHossz() {
        Assertions.assertFalse(new TajSzamValidator().isValidTajNr("1234"));
    }

    @Test
    public void testTajSzamSzoveg() {
        Assertions.assertFalse(new TajSzamValidator().isValidTajNr("abc"));
    }

    @Test
    public void testTajInvalidCrc() {
        Assertions.assertFalse(new TajSzamValidator().isValidTajNr("123456789"));
    }

    @Test
    public void testTajValidCrc() {
        Assertions.assertTrue(new TajSzamValidator().isValidTajNr("123456788"));

    }
}
