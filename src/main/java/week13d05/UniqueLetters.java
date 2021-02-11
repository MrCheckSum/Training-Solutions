package week13d05;

import java.util.HashSet;
import java.util.Set;

public class UniqueLetters {
    public int uniqueLetterCounter(String word) {
        Set<Character> result = new HashSet<>();
        for (char c : word.toLowerCase().toCharArray()) {
            if (checkLetter(c)) {
                result.add(c);
            }
        }
        System.out.println(result);
        return result.size();
    }

    private boolean checkLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        UniqueLetters uniqueLetters = new UniqueLetters();
        System.out.println(uniqueLetters.uniqueLetterCounter("alma"));
    }
}