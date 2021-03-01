package formatlocaleprintf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrintFormatTest {

    @Test
    public void lessParameterThenFormatStringShouldThrowExceptation() throws IllegalArgumentException {
        int i = 6;
        int j = 7;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new PrintFormat().formatMessageWithIntegerParameters("%d %d %d", i, j);
        });
        Assertions.assertEquals("Less objects then expected in format String!", exception.getMessage());
    }

    @Test
    public void testPrintFormattedTextDouble() {
        //Given
        Double d = 561123.201;

        //Then
        Assertions.assertEquals("Total is: 561 123,20 Ft", new PrintFormat().printFormattedText(d));
    }

    @Test
    public void testPrintFormattedTextWithIntString() {
        //Given
        String fruit = "ANANAS";
        int count = 6;

        //Then
        Assertions.assertEquals("We counted 6 ANANAS in the basket", new PrintFormat().printFormattedText(count, fruit));
    }

    @Test
    public void testPrintFormattedTextWIntegerRightEdge() {
        //Given
        int i = 5;
        int j = 55;
        int k = 555555;

        //Then
        Assertions.assertEquals("Right edge of numbers set at 4 spaces from test:   " + i, new PrintFormat().printFormattedText(i));
        Assertions.assertEquals("Right edge of numbers set at 4 spaces from test:  " + j, new PrintFormat().printFormattedText(j));
        Assertions.assertEquals("Right edge of numbers set at 4 spaces from test:" + k, new PrintFormat().printFormattedText(k));
    }

    @Test
    public void testPrintFormattedTextWMultiObject() {
        //Given
        int i = 6;
        int j = 7;
        int k = 8;

        //Then
        Assertions.assertEquals("Multiple objects containing text:" + i + "\t" + j + "\t" + k, new PrintFormat().printFormattedText(i, j, k));

    }
}
