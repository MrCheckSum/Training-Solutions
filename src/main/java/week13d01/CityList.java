package week13d01;

/*
A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza a magyar városok listáját.
Add vissza a leghosszabb nevű várost!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CityList {

    public String findMaxLengthNameCity(BufferedReader bufferedReader) {

        String maxLengthNameOfCity = "";
        int rowNumber = 0;

        try {

            // bufferedReader.readLine();  Ezzel ugorjuk át a headert
            skipHeader(bufferedReader);
            rowNumber++;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                /* Ezt a két sort kiszervezzük a getNameFromLine-ba
                String[] parts = line.split(";");
                String name = parts[1];
                */
                //System.out.println(name);
                rowNumber++;
                String name = getNameFromLine(line, rowNumber);
                if (name.length() > maxLengthNameOfCity.length()) {
                    maxLengthNameOfCity = name;
                }
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
        if (maxLengthNameOfCity.equals("")) {
            throw new IllegalArgumentException("No city found");
        }
        return maxLengthNameOfCity;
    }

    private String getNameFromLine(String line, int rowNumber) {
        String[] parts = line.split(";");
        if (parts.length <= 1) {
            throw new IllegalArgumentException("Illegal line:" + line + " row:" + rowNumber);
        }
        String name = parts[1];
        return name;

    }


    private void skipHeader(BufferedReader bufferedReader) throws IOException { //throws IOE ezzel jelezzük, hogy nem itt kezeljük le, hanem továbbengedjük
        bufferedReader.readLine();
    }

    public static void main(String[] args) {
        Path filePath = Path.of("src/main/resources/iranyitoszamok-varosok-2021.csv");
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            String city = new CityList().findMaxLengthNameCity(bufferedReader);
            System.out.println(city);
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }
}
