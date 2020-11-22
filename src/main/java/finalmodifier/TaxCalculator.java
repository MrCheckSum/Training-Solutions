package finalmodifier;

public class TaxCalculator {

    public static final double TAX = 0.27;

    public double tax(double price) {
        return price * TAX;
    }

    public double priceWithRax(double price) {
        return price + (price * TAX);
    }

    public static void main(String[] args) {

        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println("Tax: " + taxCalculator.tax(100));
        System.out.println("Price + Tax = " + taxCalculator.priceWithRax(100));

    }
}