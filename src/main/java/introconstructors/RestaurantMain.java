package introconstructors;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Kistücsök", 20);

        System.out.println(restaurant.getName());
        System.out.println(restaurant.getMenu());
        System.out.println(restaurant.getCapacity());
    }

}
