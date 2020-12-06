package introexception.patient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PatientTest {

    @Test
    public void invalidTaj(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Patient("john Doe", "abc", 1999));
    }

    @Test
    public void validTajSzam(){
        Patient patient= new Patient("John Doe", "123456788",1999);
        Assertions.assertEquals("John Doe", patient.getName());
        Assertions.assertEquals("123456788", patient.getTajNr());
        Assertions.assertEquals(1999,patient.getYearOfBirth());

    }
}
