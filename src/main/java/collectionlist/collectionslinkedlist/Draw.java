package collectionlist.collectionslinkedlist;

import java.util.*;

public class Draw {

    private List<Integer> numbers(int max) {
        List<Integer> nr = new LinkedList<>();
        for (int idx = 1; idx < max; idx++) {
            nr.add(idx);
        }
        Collections.shuffle(nr);
        return nr;
    }

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) throws IllegalArgumentException {
        Set<Integer> result = new TreeSet<>();
        if (maxNumber <= drawCount) {
            throw new IllegalArgumentException("drawCount must not be more than maxNumber:" + maxNumber);
        }
        Queue<Integer> drawing = (Queue<Integer>) numbers(maxNumber);
        while (result.size() < drawCount) {
            result.add(drawing.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        Draw draw = new Draw();
        System.out.println(draw.drawNumbers(7, 100));
    }
}