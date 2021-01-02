package algorithmscount.letters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LetterCounterTest {

    @Test
    public void letterCount(){

        Assertions.assertEquals(0, new LetterCounter().countLetters("abcdeabcd", 'f'));
        Assertions.assertEquals(2, new LetterCounter().countLetters("abcdeabcd", 'd'));
    }
}
