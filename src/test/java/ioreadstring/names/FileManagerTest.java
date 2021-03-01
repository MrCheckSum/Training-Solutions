package ioreadstring.names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    private FileManager fileManager = new FileManager("src/test/resources/names.txt");

    @Test
    public void createClassTest(){
        assertEquals("names.txt", fileManager.getFile().getFileName().toString());
        assertEquals(0, fileManager.getHumans().size());
    }

    @Test
    void readFromFile() {
        fileManager.readFromFile();
        assertEquals(5, fileManager.getHumans().size());
        assertEquals("Jane", fileManager.getHumans().get(1).getFirstName());
    }
}