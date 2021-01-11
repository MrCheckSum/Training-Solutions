package methodvarargs;

public class ExamStats {

    private double maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public double getMaxPoint() {
        return maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Result parameter is empty!");
        }

        int tops = 0;
        for (int result : results) {
            if (result > (1.0 * limitInPercent / 100) * maxPoints) {
                tops++;
            }
        }
        return tops;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Result parameter is empty!");
        }
        for (int result : results) {
            if (result < (1.0 * limitInPercent / 100) * maxPoints) {
                return true;
            }
        }
        return false;
    }

}
