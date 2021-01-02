package algorithmsdecision.integers;

import java.util.List;

public class IntegerDecisionMaker {

    public boolean containsGreaterThan(List<Integer> numbers, int minimun) {
        for (Integer number : numbers) {
            if (number > minimun) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLowerThan(List<Integer> numbers, int maximum) {
        boolean contains = false;
        int i = 0;
        while (i < numbers.size() && !contains) {
            if (numbers.get(i) < maximum) {
                contains = true;
            }
            i++;
        }
        return contains;
    }
}
