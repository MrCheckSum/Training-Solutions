/*
Mai Junior/Mid-level feladat:
Készíts egy week07d02.DigitSum osztályt és benne sumOfDigits(int x) metóódus mely visszaadja a paraméterül kapott szám számjegyeinek összegét!
pl.: 123 esetén a visszatérési érték 6. (Bocsi, hogy megint matekos holnap már nem az lesz ígérem :slightly_smiling_face:
*/
package week07d02;

public class DigitSum {

    public int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        DigitSum digitSum = new DigitSum();

        System.out.println(digitSum.sumOfDigits(123));
    }
}
