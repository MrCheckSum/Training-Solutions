package exam02;

import arrays.ArraysMain;

public class ArraySelector {

    public String selectEvens(int[] inputarray) {

        String result = "";
        int arraylength = inputarray.length;

        if (arraylength == 0) {
            return "";
        }

        for (int i = 0; i < arraylength; i = i + 2) {
            result = result + inputarray[i];

            if (i < arraylength - 2) {
                result = result + ", ";
            }
        }
        return "[" + result + "]";

    }

}
