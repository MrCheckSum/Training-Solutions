package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg kedvenc zeneszámod adatait!");
        System.out.println("Szerző:");
        song.band = scanner.nextLine();
        System.out.println("Címe:");
        song.title = scanner.nextLine();
        song.length = 40; /** legyen 40 perc*/
        System.out.println("Megadott zeneszám:" + song.band + " - " + song.title + " / (Hossza: " + song.length + " perc)");

    }
}
