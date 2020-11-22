package finalmodifier;

import java.util.Scanner;

public class Gentleman {
    public static final String MESSAGE_PREFIX = "Hello ";

    public String sayHello(String name) {
        return MESSAGE_PREFIX + name;

    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Adj meg egy férfi nevet:");
        String nameInput = scanner.nextLine();
        Gentleman gentleman = new Gentleman();
        System.out.println(gentleman.sayHello(nameInput));


    }

}