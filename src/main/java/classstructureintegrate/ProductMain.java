package classstructureintegrate;

public class ProductMain {
    public static void main(String[] args) {
        Product productMain = new Product("pohár",10);
        productMain.increase(5);
        productMain.decrease(2);
        System.out.println(productMain.getName() + " " + productMain.getPrice());
    }
}
