package controlselection.consonant;

public class ToConsonant {

    public static final String VOWELS = "aeiou";

    public char convertToConsonant(char chr) {
        if (VOWELS.indexOf(chr) >= 0) {
            return (char) (chr + 1);
        } else {
            return chr;
        }
    }
}
