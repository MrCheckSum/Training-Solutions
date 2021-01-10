package methodstructure.pendrives;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public void risePrice(int percent) {
        price += price * percent / 100;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public double pricePerCapacity() {
        return (double) price / capacity;
    }

    public boolean cheaperThan(Pendrive anotherpendrive) {
        return this.price < anotherpendrive.price;
    }

    public int comparePricePerCapacity(Pendrive anotherpendrive) {

        double pricepercapacity = pricePerCapacity();
        double anotherpricepercapacity = anotherpendrive.pricePerCapacity();

        if (pricepercapacity > anotherpricepercapacity) return 1;
        if (pricepercapacity < anotherpricepercapacity) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Pendrive pendrive = new Pendrive("a", 10, 100);
        pendrive.risePrice(20);
        System.out.println(pendrive.toString());
    }
}
