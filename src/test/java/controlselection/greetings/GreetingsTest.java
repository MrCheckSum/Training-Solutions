package controlselection.greetings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreetingsTest {
    @Test
    public void testGreet(){
        Greetings greetings = new Greetings();
        Assertions.assertEquals("Jó éjt!", greetings.greet(4,30));
        Assertions.assertEquals("Jó reggelt!", greetings.greet(5,30));
        Assertions.assertEquals("Jó napot!", greetings.greet(9,2));
        Assertions.assertEquals("Jó estét!", greetings.greet(20,0));
    }
}
