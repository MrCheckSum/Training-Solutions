package finalmodifier;

public class CylinderCalculatorBasedOnCircle {

    public double calcVolume(double radius, double high) {
        return new CircleCalculator().areaOfCircle(radius) * high;
    }

    public double calcSurface(double radius, double high) {
        return 2 * new CircleCalculator().areaOfCircle(radius) + new CircleCalculator().perimeterOfCircle(radius) * high;
    }

    public static void main(String[] args) {
        System.out.println(new CylinderCalculatorBasedOnCircle().calcSurface(5,10));
        System.out.println(new CircleCalculator().perimeterOfCircle(10));
    }
}
