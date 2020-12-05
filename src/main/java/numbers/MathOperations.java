package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        String problem = "3 / 8 + 7 / (8 - 2)";
        double result = 3 / 8.0 + 7.0 / (8 - 2);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi lett az eredmény? (4 tizedes pontosságig)");
        System.out.println(problem);

        double resultAnswered = scanner.nextDouble();

        if (Math.abs(result - resultAnswered) < 0.0001) {
            System.out.println("jó eredmény!");
        } else {
            System.out.println("hibás eredmény!");
        }
    }
}
