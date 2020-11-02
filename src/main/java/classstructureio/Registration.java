package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem adja meg a nevét!");
        String nameReg = scanner.nextLine();
        System.out.println("Kérem adja meg az email címét!");
        String emailReg = scanner.nextLine();
        System.out.println("Regisztrált adatok: " + nameReg + " és " + emailReg);

    }
}