package week15d05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class GameOfThronesTest {

    @Test
    void getHouse() throws IOException {
        GameOfThrones gameOfThrones = new GameOfThrones();
        assertEquals("Lannister:18", gameOfThrones.getHouse(Files.newBufferedReader(Path.of("battles.csv"))));
    }

}

