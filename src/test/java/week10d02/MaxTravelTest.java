package week10d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void getMaxIndex() {

        MaxTravel maxTravel=new MaxTravel();
        int max = new MaxTravel().getMaxIndex(List.of(1, 13, 0, 3, 3, 3, 4, 4, 4, 4, 4, 4, 12, 21, 22, 5));
        assertEquals(4,max);
    }
}