package week15d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    static Quiz quiz = new Quiz();

    @BeforeAll
    static void setUp() {
        quiz.fileReader("kerdesek.txt");
    }

    @Test
    void fileReader() {
        assertEquals(57, quiz.getCategories().size());
    }

    @Test
    void questionByGivenTopics() {
        assertEquals(21, quiz.questionsByGivenTopics("matematika").size());
    }


    @Test
    void questionsByGivenTopics() {
        assertEquals("Mennyi egy 3 egyseg oldalu kocka terulete?", quiz.questionsByGivenTopics("matematika").get(0));
        assertEquals("Hany kerulete van Budapestnek Budan?", quiz.questionsByGivenTopics("foldrajz").get(1));
        assertEquals("Mikor adtak ki az Aranybullat?", quiz.questionsByGivenTopics("tortenelem").get(3));

    }
}