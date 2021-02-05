package ioreadbytes.byteacount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountACharTest {

    CountAChar countAChar = new CountAChar();

    @Test
    void countACharFromByteFile() {

       assertEquals(129, countAChar.countACharFromByteFile("data.dat"));
        // mivel nincs megadva a file, hiszünk a megadott tesztnek
        // megvan a file!

    }
}