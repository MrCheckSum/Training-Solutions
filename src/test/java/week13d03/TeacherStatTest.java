package week13d03;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TeacherStatTest {

    TeacherStat teacherStat = new TeacherStat();
    String file = "src/main/resources/beosztas.txt";

    @Test
    void readFile() {
        teacherStat.readFile(file);
        assertThrows(IllegalStateException.class, () -> {
            teacherStat.readFile("src/main/resources/beoszta.txt");
        });
        assertThrows(IllegalStateException.class, () -> {
            teacherStat.readFile("");
        });

        assertThrows(NullPointerException.class, () -> {
            teacherStat.readFile(null);
        });
    }

    @Test
    void sumOfWeeklyLessonsByName() {
        teacherStat.readFile(file);
        assertEquals(18, teacherStat.sumOfWeeklyLessonsByName("Pulyka Pozsinka"));
        assertEquals(23, teacherStat.sumOfWeeklyLessonsByName("Poloska Polli"));
    }
}