package week12d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SecretTest {

    @Test
    void decoderThrowsExceptionTest() {
        Secret secret = new Secret();

        assertThrows(IllegalStateException.class, ()-> secret.decoder(Path.of("")));

        Exception exception =  assertThrows(IllegalStateException.class, ()-> secret.decoder(Path.of("")));
        assertEquals("Decoding unsuccessful!", exception.getMessage());

    }

}