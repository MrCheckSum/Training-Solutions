package week06d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StoreTest {

    @Test
    public void getProductByCategoryNameTest() {
        Store store = new Store(Arrays.asList(
                new Product("Kifli", ProductType.BAKEDGOODS, 10),
                new Product("Zsömle", ProductType.BAKEDGOODS, 20),
                new Product("Hal", ProductType.FROZEN, 100),
                new Product("Fagyi", ProductType.FROZEN, 50),
                new Product("Jégkocka", ProductType.FROZEN, 5),
                new Product("Dinnye", ProductType.OTHER, 100)));

        Assertions.assertEquals(2, store.getProductByCategoryName(ProductType.BAKEDGOODS));
        Assertions.assertEquals(3, store.getProductByCategoryName(ProductType.FROZEN));

    }
}
