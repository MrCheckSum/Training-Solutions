package controlselection.consonant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ToConsonantTest {

    @Test
    public void testVowel(){
        Assertions.assertEquals('b', new ToConsonant().convertToConsonant('a'));
        Assertions.assertEquals('f', new ToConsonant().convertToConsonant('e'));
        Assertions.assertEquals('j', new ToConsonant().convertToConsonant('i'));
    }

    @Test
    public void testConsonant(){
        Assertions.assertEquals('b',new ToConsonant().convertToConsonant('b'));
        Assertions.assertEquals('h',new ToConsonant().convertToConsonant('h'));
        Assertions.assertEquals('n',new ToConsonant().convertToConsonant('n'));
    }
}
