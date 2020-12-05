package introjunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GentlemanTest {

    @Test
    public void byName() {
        // Given
        String name = "Peter";

        // When
        String greeting = new Gentleman().sayHello(name);

        // Then
        Assertions.assertEquals("Hello Peter!", greeting);
    }

    @Test
    public void byNullName() {
        // Given
        String name = null;

        // When
        String greeting = new Gentleman().sayHello(name);

        // Then
        Assertions.assertEquals("Hello Anonymus!", greeting);
    }


    @Test
    public void byWrongName() {
        // Given
        String name = "Peter";

        // When
        String greeting = new Gentleman().sayHello(name);

        // Then
        Assertions.assertEquals("Hello Peter", greeting);
    }
}
