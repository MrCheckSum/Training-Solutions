package finalmodifier;

public class CylinderCalculator {

    public double calcVolume(double radius, double high) {
        return radius * radius * CircleCalculator.PI * high;
    }

    public double calcArea(double radius, double high) {
        return 2 * (radius * radius * CircleCalculator.PI) + (2 * radius * CircleCalculator.PI);
    }
}