/*Junior/Mid level csoport mai gyakorlati feladata:
Írj egy olyan metódust az week06d01.ListSelector osztályban, mely egy kapott listából minden második elemet kiválogat,
és egy szövegként összerak, szögletes zárójelek között.
A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
Ha üres a lista, akkor üres stringet adjunk vissza. Ha a paraméterül kapott lista null, akkor dobjunk IllegalArgumentExceptiont a metódusban.*/


package week06d01;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSelector {

    public String getElements(List<String> words) {

        StringBuilder result = new StringBuilder();

        if (words == null) {
            throw new IllegalArgumentException("Üres lista!");
        }

        if (words.size() != 0) {
            result.append("[");
            for (int i = 0; i < words.size(); i = i + 2) {
                result.append(words.get(i));
            }
            result.append("]");

        }
        return result.toString();
    }

    public static void main(String[] args) {
        ListSelector listSelector = new ListSelector();
        List<String> ls = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        System.out.println(listSelector.getElements(ls));
    }


}

