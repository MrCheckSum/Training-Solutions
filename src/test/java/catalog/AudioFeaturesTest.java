package catalog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AudioFeaturesTest {

    @Test
    public void testCreate() {
        AudioFeatures audioFeatures = new AudioFeatures("Title1", 100, Arrays.asList("Band1"));
        assertEquals("Title1", audioFeatures.getTitle());
        assertEquals(100, audioFeatures.getLength());
        assertEquals(1, audioFeatures.getContributors().size());
        assertEquals("Band1", audioFeatures.getContributors().get(0));
    }

    @Test
    public void testCreateWithComposer() {
        AudioFeatures audioFeatures = new AudioFeatures("Title1", 100, Arrays.asList("Band1"), Arrays.asList("Singer1"));
        assertEquals("Title1", audioFeatures.getTitle());
        assertEquals(100, audioFeatures.getLength());
        assertEquals(2, audioFeatures.getContributors().size());
        assertEquals("Band1", audioFeatures.getContributors().get(1));
    }

    @Test
    public void missingTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AudioFeatures("", 100, Arrays.asList("Band1"));
        });
    }

    @Test
    public void invalidLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AudioFeatures("Title1", -2, Arrays.asList("Band1"));
        });
    }

    @Test
    public void noPerformer() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AudioFeatures("Title1", -2, new ArrayList<>());
        });
    }
}