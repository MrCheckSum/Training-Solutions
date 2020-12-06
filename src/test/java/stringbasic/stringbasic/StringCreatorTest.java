package stringbasic.stringbasic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCreatorTest {

    @Test
    public void sameStringsInPoolShouldBeTheSameObject() {
        //Given
        StringCreator sc = new StringCreator();

        //Then
        Assertions.assertTrue(sc.createStringForPool() == sc.createStringForPool());
        Assertions.assertFalse(sc.createStringForHeap() == sc.createStringForHeap());
        Assertions.assertTrue(sc.createStringForPool().equals(sc.createStringForHeap()));
    }

    @Test
    public void sameStringsShouldBeTheSameByCanonicalRepresentation() {
        //Given
        StringCreator sc = new StringCreator();

        //Then
        Assertions.assertTrue(sc.createStringForHeap().intern() == sc.createStringForHeap().intern());
        Assertions.assertTrue(sc.createStringForHeap().intern() == sc.createStringForPool().intern());
    }
}
