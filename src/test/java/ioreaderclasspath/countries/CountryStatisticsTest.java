package ioreaderclasspath.countries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryStatisticsTest {

    private CountryStatistics countryStatistics = new CountryStatistics();

    @Test
    void readFile() {
        assertEquals(0, countryStatistics.getCountries().size());

        countryStatistics.readFile("ioreaderclasspath.countries/country.txt");

        assertEquals(8, countryStatistics.getCountries().size());
        assertEquals("Hungary", countryStatistics.getCountries().get(0).getName());
        assertEquals(7, countryStatistics.getCountries().get(0).getNrOfNeighboringCountries());
    }

    @Test
    void nrOfCountries() {
        assertEquals(0, countryStatistics.nrOfCountries());
        countryStatistics.readFile("ioreaderclasspath.countries/country.txt");
        assertEquals(8, countryStatistics.nrOfCountries());


    }

    @Test
    void countryWithMostNeighboringCountries() {
        countryStatistics.readFile("ioreaderclasspath.countries/country.txt");
        assertEquals("Germany", countryStatistics.countryWithMostNeighboringCountries().getName());
        assertEquals(8, countryStatistics.countryWithMostNeighboringCountries().getNrOfNeighboringCountries());
    }
}