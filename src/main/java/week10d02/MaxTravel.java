package week10d02;

/*
Van egy egész számok listája, amelyben egy szám azt jelzi, hogy az adott számú buszmegállóban egy ember fel akar szállni.
A 12,12,0,3,4,4 sorozat tehát azt jelenti, hogy a 12-es buszmegállóban 2-en, a 0-ásban 1 ember, 3-asban egy ember, 4-esben 2 ember akar felszállni.
A MaxTravel osztály getMaxIndex() metódusa adja vissza, hogy hanyas megállóban szeretnének a legtöbben felszállni. Maximum 30 megálló lehet.
 */

import java.util.Arrays;
import java.util.List;

public class MaxTravel {

    public static int getMaxIndex(List<Integer> boardingPassanger) {
        int stops[] = new int[30];
        for (int stop : boardingPassanger) {
            stops[stop]++;
        }
        System.out.println(Arrays.toString(stops));

        int max = 0;
        for (int i = 0; i < stops.length; i++) {
            if (stops[max] < stops[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int max = new MaxTravel().getMaxIndex(List.of(1, 13, 0, 3, 3, 3, 4, 4, 4, 4, 4, 4, 12, 21, 22, 5));
        System.out.println("Most boarding passangers at stop: " + max);
    }

}
