package methodstructure.bmicalculator;

public class BodyMass {

    public static double LOWER_LIMIT = 18.5;
    public static double HIGHER_LIMIT = 25.0;

    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        double result = weight / (height * height);
        return result;
    }

    public BodyCategory bmiCalc() {
        double bmiIndex = bodyMassIndex();
        if (bmiIndex < LOWER_LIMIT) return BodyCategory.UNDERWEIGHT;
        if (bmiIndex > HIGHER_LIMIT) return BodyCategory.OVERWEIGHT;
        return BodyCategory.NORMAL;

    }

    public boolean isThinnerThan(BodyMass other) {
        return bodyMassIndex() < other.bodyMassIndex();
    }

}
