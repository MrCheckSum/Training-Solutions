package interfacestaticmethods;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValuedTest {

    @Test
    void totalValue() {

        List<Valued> items = List.of(new Product("apple", 10.0),
                new Product("pearl", 4.51),
                new Product("ananas", 15.1));

        assertEquals(0.000001, 29.61, Valued.totalValue(items));

    }
}