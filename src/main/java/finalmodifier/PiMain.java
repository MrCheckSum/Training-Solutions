package finalmodifier;

import java.util.Scanner;

public class PiMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek add meg a kör/henger sugarát!:");
        double inputRadius = scanner.nextDouble();

        System.out.println("Kérlek add meg a henger magasságát!:");
        double inputHigh = scanner.nextDouble();

        System.out.println("A kör területe:" + new CircleCalculator().areaOfCircle(inputRadius));
        System.out.println("A kör kerülete:" + new CircleCalculator().perimeterOfCircle(inputRadius));
        System.out.println("A henger felülete:" + new CylinderCalculator().calcArea(inputRadius, inputHigh));
        System.out.println("A henger térfogata:" + new CylinderCalculator().calcVolume(inputRadius, inputHigh));
    }
}
