package week10d05;
/*
Készítsünk egy Calculator nevű osztályt, melynek van egy findMinSum(int[] arr) metódusa.
A metódus feladata, hogy kiírja a legkisebb összegeket 4 számból, amiket lehetséges összerakni az arr tömb elemeiből.
Példa: ha az arr tartalma [1, 3, 5, 7, 9], akkor a minimum összeg 1+3+5+7=16.
 */

import xtest.C;

import java.util.Arrays;

public class Calculator {

    public static int findMinSum(int[] arr) {
        if (arr.length < 4) throw new IllegalArgumentException("At least 4 number needed!");

        Arrays.sort(arr);

        int result = 0;
        for (int item : Arrays.copyOf(arr, 4)) {
            result = result + item;
        }
        return result;
    }

}
