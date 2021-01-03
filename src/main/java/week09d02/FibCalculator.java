/*
A week09d02 csomagban készíts egy osztályt FibCalculator néven.
Ennek legyen egy metódusa long sumEvens(int bound) néven.
Ennek a metódusnak a feladata az, hogy összeadja a páros fibonacci számokat addig,
amig a következő fibonacci szám nem nagyobb, mint bound, majd visszadja a végredményt.
 */


package week09d02;

public class FibCalculator {

    public static long sumEvens(int bound) {
        int evenfibnumbersum = 0;
        int number1 = 0;
        int number2 = 1;

        while (number2 <= bound) {
            evenfibnumbersum += number2 % 2 == 0 ? number2 : 0;
            int sumnum1andnum2 = number2 + number1;
            number1 = number2;
            number2 = sumnum1andnum2;
        }
        return evenfibnumbersum;
    }

    public static void main(String[] args) {
        System.out.println(FibCalculator.sumEvens(4));
    }
}
