package finalmodifier;

public class CircleCalculator {

    public static final double PI = 3.14;

    public double areaOfCircle(double radius) {
        return radius * radius * PI;
    }

    public double perimeterOfCircle(double radius) {
        return 2 * radius * PI;
    }

}
