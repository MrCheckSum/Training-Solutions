package week06d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {

    private List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getProductByCategoryName(ProductType productTypeName) {
        int i = 0;
        for (Product item : products) {
            if (item.getProductType() == productTypeName) {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {


        Store store = new Store(Arrays.asList(
                new Product("Kifli", ProductType.BAKEDGOODS, 10),
                new Product("Zsömle", ProductType.BAKEDGOODS, 20),
                new Product("Hal", ProductType.FROZEN, 100),
                new Product("Fagyi", ProductType.FROZEN, 50),
                new Product("Jégkocka", ProductType.FROZEN, 5),
                new Product("Dinnye", ProductType.OTHER, 100)));


        System.out.println(store.products.toString());

    }


}
