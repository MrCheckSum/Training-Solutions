package week11d01;

/*
Készítsünk egy DivisorFinder nevű osztályt, melynek van egy int findDivisors(int n) metódusa.
A feladat az, hogy megnézzük a szám minden egyes számjegyére, hogy osztója-e a számnak, majd számoljuk össze őket.
Példa: a 425-ben az 5 osztója a számnak, ezért a visszatérési érték 1.
 */
public class DivisorFinder {

    public int findDivisors(int n) {
        if (n == 0) {
            throw new IllegalStateException("0 is not allowed!");
        }

        int divisorCounter = 0;
        int digitsBreakUp = n;
        while (digitsBreakUp != 0) {
            if ((digitsBreakUp % 10 != 0) && (n % (digitsBreakUp % 10) == 0)) {
                divisorCounter++;
            }
            digitsBreakUp = digitsBreakUp / 10;
        }
        return divisorCounter;
    }

    public static void main(String[] args) {
        DivisorFinder divisorFinder = new DivisorFinder();
        System.out.println(divisorFinder.findDivisors(555));
    }
}

