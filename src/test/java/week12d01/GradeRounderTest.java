package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {
    int[] gradeRounder = new GradeRounder().roundGrades(new int[]{11, 38, 54, 67, 89});

    @Test
    void roundGrades() {
        assertEquals(Arrays.toString(new int[]{11, 38, 55, 67, 90}), Arrays.toString(gradeRounder));
    }
}