package controlselection.month;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DayInMonthTest {

    @Test
    public void testNumberOfDays() {

        Assertions.assertEquals(31, new DayInMonth().nrOfDays(2020, "január"));
        Assertions.assertEquals(30, new DayInMonth().nrOfDays(2018, "június"));
        Assertions.assertEquals(28, new DayInMonth().nrOfDays(2015, "február"));
        Assertions.assertEquals(28, new DayInMonth().nrOfDays(1900, "február"));

    }
    @Test
    public void testCase() {
        Assertions.assertEquals(31, new DayInMonth().nrOfDays(2017, "MáJuS"));
    }

    @Test
    public void testLeapYear() {
        Assertions.assertEquals(29, new DayInMonth().nrOfDays(2012, "február"));
    }

    @Test
    public void testLeapYear100() {
        Assertions.assertEquals(28, new DayInMonth().nrOfDays(1900, "február"));
    }

    @Test
    public void testLeapYear400() {
        Assertions.assertEquals(29, new DayInMonth().nrOfDays(2000, "február"));
    }

    @Test
    public void testIllegalMonth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new DayInMonth().nrOfDays(2012, "abc"));
    }

}
