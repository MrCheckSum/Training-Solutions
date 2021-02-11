package exceptions.polinom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    public void constructorDoubleNullParameterShouldThrowException() throws Exception {
        double[] coefficients = null;

        Exception exception = assertThrows(NullPointerException.class, () -> new Polynomial(coefficients));
        assertEquals("Coefficients can not be null!", exception.getMessage());
    }

    @Test
    public void constructorStringNullParameterShouldThrowException() throws Exception {
        String[] coefficients = null;

        Exception exception = assertThrows(NullPointerException.class, () -> new Polynomial(coefficients));
        assertEquals("CoefficientString can not be null!", exception.getMessage());
    }

    @Test
    public void constructorStringInvalidCoefficientShouldThrowException() throws Exception {
        String[] coefficientString = new String[]{"a", "1", "2"};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Polynomial(coefficientString));
        assertEquals("Illegal coefficients, it is not a number!", exception.getMessage());
        assertEquals("For input string: \"a\"", exception.getCause().getMessage());
    }

    @Test
    public void constructorStringShouldConvert() throws Exception {
        String[] coefficientStrs = new String[]{"1", "2", "2"};

        Polynomial polynomial = new Polynomial(coefficientStrs);

        double[] expected = new double[]{1, 2, 2};
        assertArrayEquals(expected, polynomial.getCoefficients());
    }

    @Test
    public void evaluate() throws Exception {
        Polynomial polynomial = new Polynomial(new double[]{1, 2, 3});
        double x = 1;
        assertEquals(x * x + 2 * x + 3, polynomial.evaluate(x));

        x = 2;
        assertEquals(x * x + 2 * x + 3, polynomial.evaluate(x));

        x = -2;
        assertEquals(x * x + 2 * x + 3, polynomial.evaluate(x));

        Polynomial polynomial2 = new Polynomial(new double[]{1, 1, 0, 1});
        x = 3;
        assertEquals(x * x * x + x * x + 1, polynomial2.evaluate(x));
    }

}