package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    /*
    Teszt esetből log:
    String log = "176.121.45.124:2016-12-02:derzsi\n"
                + "176.121.45.124:2016-12-03:ggrrrr\n";
     */

    public static final String SEPARATOR_LOG = ":";
    public static final String SEPARATOR_DATE = "-";

    public static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final int POSITION_OF_IPADDRESS = 0;
    public static final int POSITION_OF_DATE = 1;
    public static final int POSITION_OF_LOGIN = 2;


    public Map<String, List<Entry>> parseLog(String log) {
        if (log == null) {
            throw new IllegalArgumentException("There is no Log!");
        }

        Map<String, List<Entry>> entries = new HashMap<>();
        Scanner scanner = new Scanner(log);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Entry entry = parseLine(line);
            if (entries.containsKey(entry.getIpAddress())) {
                List<Entry> parts = new ArrayList<>(entries.get(entry.getIpAddress()));
                parts.add(entry);
                entries.replace(entry.getIpAddress(), parts);
            } else {
                entries.put(entry.getIpAddress(), List.of(entry));
            }
        }
        return entries;
    }

    private Entry parseLine(String line) {
        String[] split = line.split(SEPARATOR_LOG);
        if (split.length == 3) {
            return new Entry(split[POSITION_OF_IPADDRESS],
                    parseDate(split[POSITION_OF_DATE]),
                    split[POSITION_OF_LOGIN]);
        }
        throw new IllegalArgumentException("Incorrect log line!");
    }

    private LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, FORMAT_DATE);
        }
        catch (DateTimeParseException dateTimeParseException) {
            throw new IllegalArgumentException("Incorrect date in log line!");
        }
    }


}
