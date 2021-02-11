package week13d05;
/*
Írj egy metódust, amely megszámolja, hogy hány különböző betű van
egy szóban. A kis és nagybetűk közötti különbség nem számít!
A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az
angol ábécé betűit!
 */


import java.util.ArrayList;
import java.util.List;

public class CountEnglishAphabetLetters {

    final int MIN_CHARACTER_CODE = 97;
    final int MAX_CHARACTER_CODE = 122;

    public int letterCounter(String word) {

        System.out.println(word);
        if (word == null || word.equals("")) {
            throw new IllegalArgumentException("Wrong word!");
        }
        word = word.toLowerCase();
        int sum = 0;

        for (int idx = 0; idx < word.length() ; idx++) {
            int chrCode = (int) word.charAt(idx);
            if (MIN_CHARACTER_CODE <= chrCode && MAX_CHARACTER_CODE >= chrCode) {
                sum++;
            } // Ez nem jó így mert nem különböző karaktereket számol, hanem minden angol abc-st összead R: aaa=3, J: aaa=1
        }
        return sum;
    }

    public static void main(String[] args) {
        CountEnglishAphabetLetters ct = new CountEnglishAphabetLetters();
        System.out.println(ct.letterCounter("áé í"));
        System.out.println(ct.letterCounter("alma"));
    }
}
