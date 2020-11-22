package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {

    public static final List<String> DAYS = Arrays.asList("Monday", "Tuesday", "Wensday", "Thursday", "Friday", "Saturday", "Sunday");

    public static void main(String[] args) {
        DAYS.set(1, "Szerda");
        System.out.println(DAYS);
        DAYS.set(1, "Tuesday");
        System.out.println(DAYS);
    }

}
