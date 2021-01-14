package methodparam.measuring;

import java.util.Arrays;

public class Measurement {

    private double[] values;

    public Measurement(double[] values) {
        this.values = values;
    }

    public int findFirstIndexInLimit(int lowLimit, int maxLimit) {
        for (int idx = 0; idx < values.length; idx++) {
            if (lowLimit < values[idx] && maxLimit > values[idx]) {
                return idx;
            }
        }
        return -1;
    }

    public double minimum() {
        double min = values[0];
        for (int idx = 1; idx < values.length; idx++) {
            if (values[idx] < min) {
                min = values[idx];
            }
        }
        return min;
    }

    public double maximum() {
        double max = values[0];
        for (int idx = 1; idx < values.length; idx++) {
            if (values[idx] > max) {
                max = values[idx];
            }
        }
        return max;
    }

    public ExtremeValues minmax() {
        return new ExtremeValues(minimum(), maximum());
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

    public static void main(String[] args) {

        double[] values = new double[]{10, 4, 3, 8, 12, 5, 7, 15, 20, 62};
        Measurement measurement = new Measurement(values);
        System.out.println(values);
    }
}



