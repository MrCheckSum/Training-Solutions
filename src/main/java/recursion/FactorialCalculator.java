package recursion;

public class FactorialCalculator {

    public long getFactorial(int number) {
        if (number > 1) {
            return number * getFactorial(number - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        System.out.println(factorialCalculator.getFactorial(7));
    }
}
