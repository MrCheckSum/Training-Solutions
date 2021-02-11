package week14d01;

/*
Készíts egy Indexer osztályt, melynek van egy public Map<Character, List<String>> index(List<String> names) metódusa.
A feladat az, hogy egy indexet készítsünk a megadott nevek kezdőbetűiből
(minden kezdőbetűt társítsunk az összes névvel, mely ezzel a betűvel kezdődik).
Példa:
System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna")));
// {A=[Abraham], L=[Lujza], M=[Magdolna], O=[Odon]}
 */

import xtest.A;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String name : names) {
            char initial = name.charAt(0);
            if (!result.containsKey(initial)) {
                result.put(initial, new ArrayList<>());
            }
            result.get(initial).add(name);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Indexer().index(Arrays.asList("Ödön", "Lujza", "Ábrahám", "Magdolna", "Lajos")));
    }

    /*
    Tesztelésnél
    Map<Character, List<String>> expected = new HashMap<>();
    expected.put('A', Arrays.AsList("Abraham"));
    expected.put('L', Arrays.AsList("Lujza"));
    vagy

    Map<Character, List<String>> expected = Map.of('A', Arrays.AsList("Abraham"), 'L', Arrays.AsList("Lujza"));

     */
}
