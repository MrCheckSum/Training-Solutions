package defaultconstructor.date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleDateFormatterTest {

    private SimpleDate simpleDate;

    @BeforeEach
    public void setUp() {
        simpleDate = new SimpleDate(2020,2,29);

    }

    @AfterEach
    public void tearDown() {
        simpleDate = null;
    }

    @Test
    public void testFormatDateStringByCountryCodeHU() {

        assertEquals("2020-2-29", new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.HU, simpleDate));
    }

    @Test
    public void testFormatDateStringByCountryCodeEN() {

        assertEquals("29-2-2020", new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.EN, simpleDate));
    }

    @Test
    public void testFormatDateStringByCountryCodeUS() {

        assertEquals("2-29-2020", new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.US, simpleDate));
    }

    @Test
    public void testFormatDateString() {

        assertEquals("2020-2-29", new SimpleDateFormatter().formatDateString(simpleDate));
    }

}