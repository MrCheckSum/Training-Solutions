package week10d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void getPlusElevation() {
        Hiking hiking = new Hiking();

        double result = hiking.getPlusElevation(Arrays.asList(10d,20d,15d,18d));

        assertEquals(13, result);
    }
}