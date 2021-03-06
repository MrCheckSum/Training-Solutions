package collectionsmap;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LogParserTest {

    @Test
    void parseLog() {
        String log = "176.121.45.124:2016-12-02:derzsi\n"
                + "176.121.45.124:2016-12-03:ggrrrr\n";
        Map<String, List<Entry>> entries = new LogParser().parseLog(log);

        System.out.println(entries.get("176.121.45.124").get(0).getLogin());
        System.out.println(entries.get("176.121.45.124").get(0).getEntryDate());
        System.out.println(entries.get("176.121.45.124").get(0).getIpAddress());

        System.out.println(entries.get("176.121.45.124").get(1).getLogin());
        System.out.println(entries.get("176.121.45.124").get(1).getEntryDate());
        System.out.println(entries.get("176.121.45.124").get(1).getIpAddress());
    }

    @Test
    public void faultyLogShouldThrowException() {

        String log = "invalid_log_format";

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new LogParser().parseLog(log);
        });
        assertEquals("Incorrect log line!", ex.getMessage());
    }

    @Test
    public void invalidDateFormatShouldThrowException() {
        // Given
        String log = "176.121.45.124:20161202:derzsi\n";

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new LogParser().parseLog(log);
        });
        assertEquals("Incorrect date in log line!", ex.getMessage());
    }

    @Test
    public void entriesWithSameIpShouldBeInSameList() {
        // Given
        String log = "176.121.45.124:2016-12-02:derzsi\n"
                + "176.121.45.124:2016-12-03:ggrrrr\n";

        // When
        Map<String, List<Entry>> entries = new LogParser().parseLog(log);

        // Then
        assertEquals(1, entries.size());
        assertEquals(2, entries.get("176.121.45.124").size());
        assertEquals("derzsi", entries.get("176.121.45.124").get(0).getLogin());
        assertEquals("176.121.45.124", entries.get("176.121.45.124").get(0).getIpAddress());
        assertEquals(LocalDate.of(2016, 12, 2), entries.get("176.121.45.124").get(0).getEntryDate());
    }

}
