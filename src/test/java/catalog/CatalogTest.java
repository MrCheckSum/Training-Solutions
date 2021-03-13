package catalog;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static catalog.SearchCriteria.createByBoth;
import static catalog.SearchCriteria.createByContributor;
import static catalog.SearchCriteria.createByTitle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CatalogTest {

    public CatalogItem catalogItem1 = new CatalogItem("C1", 100,
            new AudioFeatures("Album1", 200, Arrays.asList("Band1"), Arrays.asList("Song1")),
            new PrintedFeatures("Title1", 400, Arrays.asList("Author1")),
            new AudioFeatures("Album2", 300, Arrays.asList("Band2"), Arrays.asList("Iron Maiden"))

    );

    public CatalogItem catalogItem2 = new CatalogItem("C2", 100,
            new PrintedFeatures("Title1", 500, Arrays.asList("Author1"))
    );


    public CatalogItem catalogItem3 = new CatalogItem("C3", 100,
            new AudioFeatures("Album3", 100, Arrays.asList("Title3"), Arrays.asList("Band3"))
    );

    public Catalog catalog = new Catalog();


    @Test
    public void testAddAndDeleteItem() {
        assertEquals(0, catalog.catalogItems.size());
        catalog.addItem(catalogItem1);
        assertEquals(1, catalog.catalogItems.size());
        catalog.deleteItemByRegistrationNumber("C1");
        assertEquals(0, catalog.catalogItems.size());
    }

    @Test
    public void testGetAudioLibraryItems() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        assertEquals(1, catalog.getAudioLibraryItems().size());
    }

    @Test
    public void testGetPrintedLibraryItems() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        assertEquals(2, catalog.getPrintedLibraryItems().size());
    }

    @Test
    public void testGetAllPageNumber() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        assertEquals(900, catalog.getAllPageNumber());
    }

    @Test
    public void testGetFullLength() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        catalog.addItem(catalogItem3);
        assertEquals(600, catalog.getFullLength());
    }

    @Test
    public void testAveragePageWithIllegalArgument() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        catalog.addItem(catalogItem3);
        Exception actualException = assertThrows(IllegalArgumentException.class, () -> {
            catalog.averagePageNumberOver(0);
        });
        assertEquals("Page number can not be negative!", actualException.getMessage());
    }

    @Test
    public void testAveragePageWithZero() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        catalog.addItem(catalogItem3);
        Exception actualException = assertThrows(IllegalArgumentException.class, () -> {
            catalog.averagePageNumberOver(10000);
        });
        assertEquals("There is no page!", actualException.getMessage());
    }

    @Test
    public void testAveragePageNumberOverVariable() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        catalog.addItem(catalogItem3);
        assertEquals(450.0, catalog.averagePageNumberOver(100));

    }

    @Test
    public void testFindByCriteriaBoth() {
        SearchCriteria searchCriteria = createByBoth("Album1", "Band1");
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        assertEquals(1, catalog.findByCriteria(searchCriteria).size());
        assertEquals("Album1", catalog.findByCriteria(searchCriteria).get(0).getFeatures().get(0).getTitle());
    }

    @Test
    public void testFindByCriteriaContributor() {
        SearchCriteria searchCriteria = createByContributor("Song1");
        catalog.addItem(catalogItem1);
        assertEquals(1, catalog.findByCriteria(searchCriteria).size());
    }

    @Test
    public void testFindByCriteriaTitle() {
        SearchCriteria searchCriteria = createByTitle("Title1");
        catalog.addItem(catalogItem1);
        assertEquals(1, catalog.findByCriteria(searchCriteria).size());
    }
}
