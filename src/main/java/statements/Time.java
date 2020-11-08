package statements;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getInMinutes() {
        int hourInMinute = 60;
        return getHour() * hourInMinute + getMinute();
    }

    public int getInSeconds() {
        int hourInSeconds = getHour() * 60 * 60;
        int minutesInSeconds = getMinute() * 60;
        return hourInSeconds + minutesInSeconds + getSecond();
    }

    public boolean earlierThan(Time time2) {
        int time1TimeInSeconds = this.getInSeconds();
        int time2TimeInSeconds = time2.getInSeconds();
        return time1TimeInSeconds < time2TimeInSeconds;
    }

    public String toString() {
        return getHour() + ":" + getMinute() + ":" + getSecond();
    }
}
