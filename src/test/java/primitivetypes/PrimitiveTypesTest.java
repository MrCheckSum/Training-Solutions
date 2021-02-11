package primitivetypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveTypesTest {

    @Test
    void toBinaryString() {

        PrimitiveTypes pt = new PrimitiveTypes();
        System.out.println(pt.toBinaryString(10));
        System.out.println(Integer.toBinaryString(10));

        assertEquals(00000000000000000000000000001010, pt.toBinaryString(10));
        assertEquals(1010, Integer.toBinaryString(10));

    }
}