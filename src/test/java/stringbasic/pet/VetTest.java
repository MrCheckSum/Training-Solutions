package stringbasic.pet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class VetTest {


    @Test
    public void testAddDifferent() {
        Vet vet = new Vet();

        vet.add(new Pet("Frakk", LocalDate.of(2015, 9, 21), Gender.MALE, "001235"));
        vet.add(new Pet("Sajó", LocalDate.of(2011, 3, 9), Gender.FEMALE, "000135"));

        Assertions.assertEquals(2, vet.getPets().size());
    }

    @Test
    public void testAddSame() {
        Vet vet = new Vet();

        vet.add(new Pet("Frakk", LocalDate.of(2015, 9, 21), Gender.MALE, "001235"));
        vet.add(new Pet("Sajó", LocalDate.of(2011, 3, 9), Gender.FEMALE, "001235"));

        Assertions.assertEquals(1, vet.getPets().size());
    }
}
