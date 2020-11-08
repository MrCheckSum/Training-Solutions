package statements;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg az első időpont óráját!");
        int hour1 =scanner.nextInt();
        System.out.println("Add meg az első időpont percét!");
        int minute1 =scanner.nextInt();
        System.out.println("Add meg az első időpont másodpercét!");
        int second1 =scanner.nextInt();

        System.out.println("Add meg a második időpont óráját!");
        int hour2 =scanner.nextInt();
        System.out.println("Add meg a második időpont percét!");
        int minute2 =scanner.nextInt();
        System.out.println("Add meg második időpont másodpercét!");
        int second2 =scanner.nextInt();

        Time time1 = new Time(hour1,minute1,second1);
        Time time2 = new Time(hour2, minute2, second2);

        System.out.println("1. időpont: " + time1.toString() + " = " + time1.getInMinutes() + " perc");
        System.out.println("2. időpont: " + time2.toString() + " = " + time2.getInSeconds() + " másodperc");
        System.out.println("1. időpont < 2. időpont? :" + time1.earlierThan(time2));

    }

}
