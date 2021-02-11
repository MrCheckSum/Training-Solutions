package week15d01;

import java.util.Map;

/*
Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk egy Map-ben.
A map kulcsa az x koordináta értéke pedig az y koordináta. Döntsük el, hogy a kapott pontok küzül, hol van a függvénynek maximum helye és ott mennyi az értéke.
 */
public class Graph {

    public Map.Entry<Double, Double> findMaxEntryValue(Map<Double, Double> graphFunction) {

        if (graphFunction.size() == 0) {
            throw new IllegalArgumentException("Illegal parameter!");
        }

        Map.Entry<Double, Double> result = null;

        for (Map.Entry<Double, Double> entry : graphFunction.entrySet()) {
            if (result == null || result.getValue() < entry.getValue()) {
                result = entry;
            }
        }
        return result;
    }
}
