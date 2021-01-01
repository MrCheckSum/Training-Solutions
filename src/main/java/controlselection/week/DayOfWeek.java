package controlselection.week;

import java.util.Locale;

public class DayOfWeek {
    public String whichDay(String day) {
        switch (day.toLowerCase()) {
            case "hétfő":
                return "hét eleje";
            case "kedd":
            case "szerda":
            case "csütörtök":
                return "hét közepe";
            case "péntek":
                return "majdnem hétvége";
            case "szombat":
            case "vasárnap":
                return "hét vége";
            default:
                throw new IllegalArgumentException("Nem valós nap" + day);
        }
    }
}
