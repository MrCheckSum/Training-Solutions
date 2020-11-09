package array;

import java.lang.Math;

public class ArrayMain {

    public static void main(String[] args) {
        String[] weekDays = {"Monday", "Tuesday", "Wednsday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(weekDays[1]);
        System.out.println(weekDays.length);

        int[] powersOfTwo = new int[5];
        powersOfTwo[0] = 1;
        for (int i = 1; i < powersOfTwo.length; i++) {
            powersOfTwo[i] = powersOfTwo[i - 1] * 2;
            System.out.println(powersOfTwo[i]);
        }

        for (int i = 0; i < powersOfTwo.length; i++) {
            System.out.print(powersOfTwo[i] + " ");
        }

        boolean[] booleans1 = new boolean[6];

        for (int i = 1; i < booleans1.length; i++) {
            booleans1[i] = !booleans1[i - 1];
            System.out.println(booleans1[i]);
        }

        for (int i = 0; i < booleans1.length; i++) {
            System.out.print(booleans1[i] + " ");
        }
    }
}