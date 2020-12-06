/*
Junior/Mid level csoport mai gyakorlati feladata:
Készíts az week06d04 csomagban egy Budget osztályt, amely a konstruktorában Item példányokat vár listában (List).
Az Item tartalmazza az alábbi attribútumokat: int price, int month, String name.
A Budget osztály tárolja el egy attribútumban a konstruktorban megkapott items listát.
Írjunk egy metódust, getItemsByMonth néven, mely egy hónapot vár (1-12) és visszaadja az Itemeket az adott hónapban!
Bónusz feladat: ellenőrizzük a bemeneti paramétereket és írjunk tesztet! (edited)
 */

package week06d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Budget {

    List<Item> itemList = new ArrayList<>();

    public Budget(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemsByMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Helytelen hónapszám!");
        }

        List<Item> itemsByMonth = new ArrayList<>();
        for (Item item : itemList) {
            if (item.getMonth() == month) {
                itemsByMonth.add(item);
            }
        }
        return itemsByMonth;
    }

    public static void main(String[] args) {
        Budget budget = new Budget(Arrays.asList(
                new Item("Termék_1", 2, 5),
                new Item("Termék_2", 5, 6),
                new Item("Termék_3", 7, 6)
        ));

        System.out.println(budget.getItemsByMonth(2));
        System.out.println(budget.getItemsByMonth(6));
        System.out.println(budget.getItemsByMonth(5));
        System.out.println(budget.getItemsByMonth(20));
    }
}
