package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store storeMain = new Store("Kecske");
        storeMain.store(5);
        storeMain.dispatch(3);
        System.out.println(storeMain.getProduct() + " in the stock:" + storeMain.getStock());

        Store storeMain2 = new Store("Bárány");
        storeMain2.store(10);
        storeMain2.dispatch(4);
        storeMain2.store(20);
        storeMain2.dispatch(12);
        System.out.println(storeMain2.getProduct() + " in the stock:" + storeMain2.getStock() );

    }
}
