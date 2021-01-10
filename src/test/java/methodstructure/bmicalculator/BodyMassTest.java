package methodstructure.bmicalculator;

import org.junit.jupiter.api.Test;
import xtest.B;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassTest {

    private static final double SAMPLE_MASS_NORMAL = 60;
    private static final double SAMPLE_HEIGHT_NORMAL = 1.7;
    private static final double SAMPLE_MASS_UNDER = 60;
    private static final double SAMPLE_HEIGHT_UNDER = 1.85;
    private static final double SAMPLE_MASS_OVER = 130;
    private static final double SAMPLE_HEIGHT_OVER = 2.1;


    @Test
    void bodyMassIndex() {

        BodyMass bodyMass = new BodyMass(SAMPLE_MASS_NORMAL, SAMPLE_HEIGHT_NORMAL);
        double expBmi = SAMPLE_MASS_NORMAL / (SAMPLE_HEIGHT_NORMAL * SAMPLE_HEIGHT_NORMAL);
        assertEquals(expBmi, bodyMass.bodyMassIndex());

    }

    @Test
    void bmiCalc() {

        BodyMass bodyMassNormal = new BodyMass(SAMPLE_MASS_NORMAL, SAMPLE_HEIGHT_NORMAL);
        BodyMass bodyMassUnder = new BodyMass(SAMPLE_MASS_UNDER, SAMPLE_HEIGHT_UNDER);
        BodyMass bodyMassOver = new BodyMass(SAMPLE_MASS_OVER, SAMPLE_HEIGHT_OVER);

        assertEquals(BodyCategory.NORMAL, bodyMassNormal.bmiCalc());
        assertEquals(BodyCategory.UNDERWEIGHT, bodyMassUnder.bmiCalc());
        assertEquals(BodyCategory.OVERWEIGHT, bodyMassOver.bmiCalc());
    }

    @Test
    void isThinnerThan() {
        BodyMass bodyMassN = new BodyMass(SAMPLE_MASS_NORMAL, SAMPLE_HEIGHT_NORMAL);
        BodyMass bodyMassU = new BodyMass(SAMPLE_MASS_UNDER, SAMPLE_HEIGHT_UNDER);

        assertFalse(bodyMassN.isThinnerThan(bodyMassU));
        assertTrue(bodyMassU.isThinnerThan(bodyMassN));
        assertFalse(bodyMassN.isThinnerThan(bodyMassN));
    }
}