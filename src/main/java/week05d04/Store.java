package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public boolean addProduct(Product product) {
        if (!isValid(product)) {
            return false;
        }
        products.add(product);
        return true;
    }

    public List<Product> getProduct() {
        return products;
    }

    public int getNrOfExpProd() {
        int exp = 0;
        for (Product item : products) {
            if (item.getExpDate().isBefore(LocalDate.now())) {
                exp++;
            }
        }
        return exp;
    }

    private boolean isContainedByName(Product product) {
        for (Product item : products) {
            if (item.getName().equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(Product product) {
        if (isContainedByName(product) || product.isExpired()) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Store store = new Store();
        store.addProduct(new Product("alma", 2020, 11, 25));
        store.addProduct(new Product("körte", 2020, 12, 1));

        System.out.println(store.getProduct().toString());
        System.out.println("Lejárt termékek száma: " + store.getNrOfExpProd());

    }

}
