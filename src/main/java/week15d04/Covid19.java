package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Letölthetőek a koronavírus adatok innen: https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv
Melyik három héten volt Magyarországon a legtöbb esetszám?
 */
public class Covid19 {
    private List<Covid19ByWeeks> covidList = new ArrayList<>();

    public void readFile(BufferedReader bufferedReader) {
        try {
            String line;
            bufferedReader.lines();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("Hungary")) {
                    covidList.add(processLine(line));
                }
            }
        } catch (IOException ioException) {
            throw new IllegalArgumentException("File reading is failed!", ioException);
        }
    }

    private Covid19ByWeeks processLine(String line) {
        String[] temp = line.split(",");
        int nrOfCases = Integer.parseInt(temp[2]);
        return new Covid19ByWeeks(temp[1], nrOfCases);
    }


    public List<Covid19ByWeeks> getCovidList() {
        return new ArrayList<>(covidList);
    }

    public List<String> findFirstThree() {
        List<Covid19ByWeeks> sortedList = new ArrayList<>(covidList);
        Collections.sort(sortedList);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(sortedList.get(i).getWeek());
        }
        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("data.csv"))) {
            Covid19 covid19 = new Covid19();
            covid19.readFile(bufferedReader);
            System.out.println(covid19.findFirstThree());
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }
}