package week11d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    void wordsWithCharTest() {
        WordFilter wordFilter = new WordFilter();

        List<String> listWordFiltered = wordFilter.wordsWithChar(List.of("macska", "kutya", "párduc"), 'c');
        List<String> expected = List.of("macska", "párduc");

        assertEquals(expected, listWordFiltered);
    }
}