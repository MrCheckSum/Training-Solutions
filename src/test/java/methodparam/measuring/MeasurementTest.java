package methodparam.measuring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    private Measurement measurement;

    @BeforeEach
    public void setUp() {
        double[] values = new double[]{10, 4, 3, 8, 12, 5, 7, 15, 20, 62};
        this.measurement = new Measurement(values);
    }

    @AfterEach
    public void tearDown() {
        this.measurement = null;
    }

    @Test
    public void findFirstIndexInLimit() {
        assertEquals(6, this.measurement.findFirstIndexInLimit(5, 8));
        assertEquals(-1, this.measurement.findFirstIndexInLimit(0, 1));
    }

    @Test
    public void testMinimum() {
        assertEquals(3.0, this.measurement.minimum());
    }

    @Test
    public void testMaximum() {
        assertEquals(62.0, this.measurement.maximum());
    }

    @Test
    public void testMinmax() {
        ExtremeValues extremeValues = this.measurement.minmax();
        assertEquals(3.0, extremeValues.getMin());
        assertEquals(62.0, extremeValues.getMax());
    }
}