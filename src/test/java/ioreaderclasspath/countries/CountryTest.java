package ioreaderclasspath.countries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    private Country country = new Country("Hungary", 7);

    @Test
    void createCountry() {

        assertEquals("Hungary", country.getName());
        assertEquals(7, country.getNrOfNeighboringCountries());

    }
}