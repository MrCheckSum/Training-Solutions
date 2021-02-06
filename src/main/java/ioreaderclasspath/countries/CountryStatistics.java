package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countries = new ArrayList<>();

    public void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream("/" + fileName)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tempData = line.split(" ");
                Country country = new Country(tempData[0], Integer.parseInt(tempData[1]));
                countries.add(country);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }

    public int nrOfCountries() {
        return countries.size();
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public Country countryWithMostNeighboringCountries() {
        Country max = countries.get(0);
        for (Country country : countries) {
            if (country.getNrOfNeighboringCountries() > max.getNrOfNeighboringCountries()) {
                max = country;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
