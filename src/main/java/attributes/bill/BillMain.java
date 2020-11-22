package attributes.bill;

public class BillMain {
    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("Alma", 1, 100));
        bill.addItem(new Item("Körte", 2, 200));
        bill.addItem(new Item("banán", 3, 300));

        System.out.println(bill.calculateTotalPrice());
    }
}
