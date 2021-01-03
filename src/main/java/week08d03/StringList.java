/*
Készíts week08d03 csomagban egy StringLists osztályt és benne egy stringListsUnion(List<String> first, List<String> second) metódust,
mely két string listát vár paraméterül és visszaadja az uniójukat. Az úniónak minden elemet tartalmaznia kell mindkét listából,
de egy elem nem szerepelhet kétszer!
 */

package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringList {

    public List<String> stringListUnion(List<String> first, List<String> second) {
        List<String> result = new ArrayList<>(first);

        for (String s : second) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }
}