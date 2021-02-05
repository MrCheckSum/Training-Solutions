package iostringwriter.longwords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongWordsTest {

    LongWords lw = new LongWords();
    List<String> words = List.of("Megszentsegtelenithetetlensegeskedeseitekert", "rezfanfuttyulorezangyal");

    @Test
    void stringWriteLongWords() {

        String s = lw.stringWriteLongWords(words);
        String[] temp = s.split("\n");
        String[] temp2 = temp[0].split("=");
        assertEquals(2, temp.length);
        assertEquals(true, temp2[1].contains("44"));

    }
}