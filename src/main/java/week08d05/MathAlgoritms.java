/*
A week08d05 csomagban készíts egy osztályt MathAlgorithms néven.
Legyen benne egy metódus, greatestCommonDivisor(),
ami paraméterül vár két pozitív egész számot és visszaadja a legnagyobb közös osztójukat.
:+1:
1


 */

package week08d05;

public class MathAlgoritms {

    public static int greatestCommonDivisor(int number1, int number2) {
        int result = 1;
        for (int factor = 1; factor < number1 || factor < number2; factor++) {
            if (number1 % factor == 0 && number2 % factor == 0) {
                result = factor;
            }
        }
        return result;
    }

    public static void main(String[] args) {
       System.out.println(MathAlgoritms.greatestCommonDivisor(170, 357));
    }
}
