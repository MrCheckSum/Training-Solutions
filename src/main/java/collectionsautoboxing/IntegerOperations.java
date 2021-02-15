package collectionsautoboxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers) {
        List<Integer> result = new ArrayList<>(numbers.length);

        for (int item : numbers) {
            result.add(item);
        }

        return result;
    }

    public int sumIntegerList(List<Integer> integerList) {
        if (integerList == null) throw new IllegalArgumentException("Paramater can not be null!");

        int result = 0;
        for (Integer item : integerList) {
            result += item;
        }

        return result;
    }

    public int sumIntegerObjects(Integer... integers) {
        int result = 0;
        for (Integer item : integers) {
            result += item;
        }

        return result;
    }

    public static void main(String[] args) {
        IntegerOperations integerOperations = new IntegerOperations();
        integerOperations.createList(10, 3, 4, 5, 6, 7);

        System.out.println(integerOperations.createList(10, 3, 4, 5, 6, 7));
        System.out.println(integerOperations.sumIntegerList(integerOperations.createList(10, 3, 4, 5, 6, 7)));
        System.out.println(integerOperations.sumIntegerObjects(1, 4, 5, 6));
    }

}
