package week06d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordEraserTest {

    @Test
    public void eraseWordTest() {
        WordEraser wordEraser = new WordEraser();
        String words = "alma körte barack alma szilva körte birsalma";
        String word = "alma";
        String result = "körte barack szilva körte birsalma";

        Assertions.assertEquals(result, wordEraser.eraseWord(words, word));

    }
}

