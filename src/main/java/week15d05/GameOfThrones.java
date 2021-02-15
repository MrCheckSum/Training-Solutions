package week15d05;
/*
Junior feladat
Adott egy fájl a következő címen:
https://raw.githubusercontent.com/TheMLGuy/Game-of-Thrones-Dataset/master/battles.csv
Melyik ház vett részt a legtöbb csatában?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfThrones {

    public String getHouse(BufferedReader reader) throws IOException {
        reader.readLine();
        String line;
        Map<String, Integer> numberOfBattles = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            List<String> houses = new ArrayList<>();
            for (int i = 5; i < 12; i++) {
                if (!parts[i].isBlank()) {
                    houses.add(parts[i]);
                }
            }
            for (String house : houses) {
                if (numberOfBattles.containsKey(house)) {
                    numberOfBattles.put(house, numberOfBattles.get(house) + 1);
                } else {
                    numberOfBattles.put(house, 1);
                }
            }
        }
        int max = 0;
        String house = null;
        for (Map.Entry<String, Integer> entry:numberOfBattles.entrySet()){

            if (entry.getValue() > max) {
                max = entry.getValue();
                house= entry.getKey();
            }
        }
        return house +":"+max;
        }

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("battles.csv"))) {
            String house = new GameOfThrones().getHouse(reader);
            System.out.println(house);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
