package statements;

import java.util.Scanner;

public class DiviByThree {
    public static void main(String[] args) {
        System.out.println("Írj be egy egész számot!");
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        if (number1 % 3 == 0) {
            System.out.println(number1 + " osztható 3-al");
        } else {
            System.out.println(number1 + " nem osztható 3-al");
        }
    }
}
