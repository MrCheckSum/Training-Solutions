package stringbuilder;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalidromeValidatorTest {

    public void nulParameterShouldThrowExceptation() throws IllegalArgumentException {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,()-> new PalindromeValidator().isPalidrome(null));
        Assertions.assertEquals("Text is null!", exception.getMessage());
    }

    @Test
    public void isPalidrome(){
        Assertions.assertTrue(new PalindromeValidator().isPalidrome("racecar"));
        Assertions.assertFalse(new PalindromeValidator().isPalidrome("end"));
        Assertions.assertTrue(new PalindromeValidator().isPalidrome(""));
        Assertions.assertTrue(new PalindromeValidator().isPalidrome("\n\t"));
    }
}
