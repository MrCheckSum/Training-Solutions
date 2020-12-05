package numbers;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Első kör átmérője:  ");
        int diameter = scanner.nextInt();
        Circle circle = new Circle(diameter);

        System.out.println("Második kör átmérője:  ");
        int diameter1 = scanner.nextInt();
        Circle circle1 = new Circle(diameter1);

        System.out.println("Az első kör kerülete:  " + circle.perimeter());
        System.out.println("Az első kör területe:  " + circle.area());

        System.out.println("A második kör kerülete:  " + circle1.perimeter());
        System.out.println("A második kör területe:  "+ circle1.area());
    }
}
