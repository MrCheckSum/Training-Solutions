package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Első szám megadása:");
        int firstNumber = scanner.nextInt();
        System.out.println("Második szám megadása:");
        int secondNumber = scanner.nextInt();
        System.out.println("Eredmény:");
        System.out.println("" + firstNumber +"+" + secondNumber);
        System.out.println(firstNumber + secondNumber);
    }
}