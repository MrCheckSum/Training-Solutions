package week05d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    @Test
    public void addProductTest() {
        Store store = new Store();

        assertFalse(store.addProduct(new Product("alma", 2020, 11, 20)));

        assertTrue(store.addProduct(new Product("körte", 2020, 11, 30)));
        assertFalse(store.addProduct(new Product("körte", 2020, 12, 15)));
    }

    @Test
    public void getNumberofExpired() {
    }

    ;

}
