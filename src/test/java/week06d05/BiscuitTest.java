package week06d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BiscuitTest {

    @Test
    public void getTested() {
        Biscuit biscuit = new Biscuit(BiscuitType.KEKSZ_1, 150);

        Assertions.assertEquals("KEKSZ_1: 150 g", biscuit.toString());
    }

}
