package exceptions.polinom;

public class Polynomial {

    private double[] coefficients;


    public Polynomial(double[] coefficients) {
        if (coefficients == null) throw new IllegalArgumentException("Coefficients can not be null!");
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientsStrings) {
        if (coefficientsStrings == null) {
            throw new NullPointerException("CoefficientString can not be null!");
        }
        try {
            this.coefficients = convertCoefficinetString(coefficientsStrings);
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException("Illegal coefficients, it is not a number!", exception);
        }
    }

    private double[] convertCoefficinetString(String[] coefficientString) {
        double[] coefficients = new double[coefficientString.length];
        for (int i = 0; i < coefficientString.length; i++) {
            coefficients[i] = Double.parseDouble(coefficientString[i]);
        }
        return coefficients;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double evaluate(double x) {
        int n = coefficients.length - 1;
        double sum = 0;
        for (int i = 0; i >= 0; i++) {
            sum += coefficients[i] * Math.pow(x, (double) n - i);
        }
        return sum;
    }
}