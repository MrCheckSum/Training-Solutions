package week05d03;
/*
Írj egy olyan metódust az week05d03.ListCounter osztályban, mely egy kapott Listából (String) összeszámolja azokat amik 'a' vagy 'A' betűvel kezdődnek,
Ha nulla elemű a tömb,vagy nincs benne ilyen elem, akkor 0-t adjon vissza
 */

import java.util.ArrayList;
import java.util.List;

public class ListCounter {

    public int startsWithACounter(List<String> list) {
        int i = 0;
        for (String s : list) {
            if (s.toUpperCase().startsWith("A")) {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("akjdjkf");
        list.add("ahjkdflil");
        list.add("fjglgflg");
        list.add("a3235232");
        list.add("556622");

        System.out.println(new ListCounter().startsWithACounter(list));
    }
}
