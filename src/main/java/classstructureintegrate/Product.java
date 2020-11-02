package classstructureintegrate;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {this.name = name; this.price=price;
    }

    public String getName() {
        return this.name = name;
    }

    public int getPrice() {
        return this.price = price;
    }

    public void increase(int increaseAmount) {
        price = price + increaseAmount;
    }

    public void decrease(int decreaseAmount) {
        price = price - decreaseAmount;
    }
}
