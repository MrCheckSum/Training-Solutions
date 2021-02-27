package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private final List<SimpleTime> timeList;

    public BusTimeTable(List<SimpleTime> timeList) {
        this.timeList = timeList;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        List<SimpleTime> generatedTimeTable = new ArrayList<>();
        for (int i = firstHour; i <= lastHour; i++) {
            generatedTimeTable.add(new SimpleTime(i, everyMinute));
        }
        timeList = generatedTimeTable;
    }

    public List<SimpleTime> getTimeList() {
        return timeList;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        for (int i = 0; i < timeList.size(); i++) {
            if (timeList.get(i).difference(actual) >= 0) {
                return timeList.get(i);
            }
        }
        throw new IllegalStateException("There is no more bus available!");
    }
}
