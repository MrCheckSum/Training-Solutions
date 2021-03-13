package catalog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintedFeaturesTest {

    @Test
    public void testCreate() {
        PrintedFeatures audioFeatures = new PrintedFeatures("Title1", 100, Arrays.asList("Author1", "Author2"));

        assertEquals(2, audioFeatures.getContributors().size());
        assertEquals("Author2", audioFeatures.getContributors().get(1));
        assertEquals("Title1", audioFeatures.getTitle());
        assertEquals(100, audioFeatures.getNumberOfPages());
    }

    @Test
    public void missingTitle() {
        Exception actualException = assertThrows(IllegalArgumentException.class, () -> {
            new PrintedFeatures("", 100, Arrays.asList("Author1", "Author2"));
        });
        assertEquals("Empty title", actualException.getMessage());
    }

    @Test
    public void invalidNumberOfPages() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PrintedFeatures("Title1", -1, Arrays.asList("Author1", "Author2"));
        });
    }

    @Test
    public void noPerformer() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PrintedFeatures("Title1", 100, null);
        });
    }
}