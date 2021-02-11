package week14d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContractCreatorTest {

    @Test
    void create() {
        List<Integer> monthlyPrices = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12));
        ContractCreator contractCreator = new ContractCreator("client1", monthlyPrices);

        Contract contract1 = contractCreator.create("Jack");
        Contract contract2 = contractCreator.create("James");

        assertEquals("Jack", contract1.getClient());
        assertEquals(2, contract1.getMonthlyPrices().get(1));
        assertEquals("James", contract2.getClient());
        assertEquals(2, contract2.getMonthlyPrices().get(1));

        contract1.getMonthlyPrices().set(0, 10);

        assertEquals(10, contract1.getMonthlyPrices().get(0));
        assertEquals("Jack", contract1.getClient());
        assertEquals(1, contract2.getMonthlyPrices().get(0));
        assertEquals("James", contract2.getClient());

    }
}