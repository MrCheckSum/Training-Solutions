
package catalog;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogItemTest {

    CatalogItem catalogItem = new CatalogItem("C1", 100,
            new AudioFeatures("Album1", 200, Arrays.asList("Band1"), Arrays.asList("Song1")),
            new PrintedFeatures("Title1", 400, Arrays.asList("Author1")),
            new AudioFeatures("Album2", 300, Arrays.asList("Band2"), Arrays.asList("Song2"))
    );

    CatalogItem catalogItem2 = new CatalogItem("C2", 100,
            new PrintedFeatures("Title1", 400, Arrays.asList("Author1"))
    );

    @Test
    public void testGetFeaturesGetAudioContributors() {
        List<String> result = Arrays.asList("Song1", "Band1");
        assertEquals(result, catalogItem.getFeatures().get(0).getContributors());
    }

    @Test
    public void testGetFeaturesGetPrintedContributors() {
        List<String> result = Arrays.asList("Author1");

        assertEquals(result, catalogItem.getFeatures().get(1).getContributors());
    }

    @Test
    public void testCreate() {
        assertEquals(100, catalogItem.getPrice());
        assertEquals("C1", catalogItem.getRegistrationNumber());
    }

    @Test
    public void testNumberOfPagesAtOneItem() {
        assertEquals(400, catalogItem.numberOfPagesAtOneItem());
    }

    @Test
    public void testFullLengthAtOneItem() {
        assertEquals(500, catalogItem.fullLengthAtOneItem());
    }

    @Test
    public void testGetAllContributorsFromOneItem() {
        List<String> result = Arrays.asList("Song1", "Band1", "Author1", "Song2", "Band2");

        assertEquals(result, catalogItem.getContributors());
    }

    @Test
    public void testGetTitlesFromAllFeature() {
        List<String> result = Arrays.asList("Album1", "Title1", "Album2");

        assertEquals(result, catalogItem.getTitles());
    }

    @Test
    public void testHasAudioFeature() {
        assertTrue(catalogItem.hasAudioFeature());
        assertFalse(catalogItem2.hasAudioFeature());
    }

    @Test
    public void testHasPrintedFeature() {
        assertTrue(catalogItem.hasAudioFeature());
        assertTrue(catalogItem2.hasPrintedFeature());
    }
}