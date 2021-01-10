package week10d01;
/*
Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot (mindegyik lebegőpontos érték).
Írj a week10d01.Hiking osztályba egy getPlusElevation() metódust, mely megkapja a magasságok listáját, és visszaadja
a emelkedések összegét. Azaz pl. 10,20,15,18 esetén 13, ugyanis (20 - 10) + (18 - 15). A 20 méterről 15 méterre ereszkedést nem számolja bele,
hiszen az ereszkedés, és nem emelkedés.
 */

import java.util.Arrays;
import java.util.List;

public class Hiking {

    public double getPlusElevation(List<Double> values) {
        double altitudeelevation = 0;
        for (int i = 1; i < values.size(); i++)
            if (values.get(i) > values.get(i - 1))
                altitudeelevation += values.get(i) - values.get(i - 1);
        return altitudeelevation;
    }

    public static void main(String[] args) {
        Hiking hiking = new Hiking();
        List<Double> hghts = List.of(10.0, 20.0, 15.0, 18.0);
        System.out.println(hiking.getPlusElevation(hghts));
    }
}
