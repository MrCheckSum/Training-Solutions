
package catalog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchCriteriaTest {

    @Test
    public void testCreateByTitle() {
        SearchCriteria searchCriteria = SearchCriteria.createByTitle("Title1");

        assertEquals("Title1", searchCriteria.getTitle());
        assertTrue(searchCriteria.hasTitle());
        assertFalse(searchCriteria.hasContributor());
    }

    @Test
    public void testCreateByContributor() {
        SearchCriteria searchCriteria = SearchCriteria.createByContributor("Band1");

        assertEquals("Band1", searchCriteria.getContributor());
        assertFalse(searchCriteria.hasTitle());
        assertTrue(searchCriteria.hasContributor());
    }

    @Test
    public void testCreateByBoth() {
        SearchCriteria searchCriteria = SearchCriteria.createByBoth("Title1", "Band1");

        assertEquals("Title1", searchCriteria.getTitle());
        assertEquals("Band1", searchCriteria.getContributor());
        assertTrue(searchCriteria.hasTitle());
        assertTrue(searchCriteria.hasContributor());
    }

    @Test
    public void testInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            SearchCriteria.createByTitle(null);
        });
    }

    @Test
    public void testInvalidContributor() {
        assertThrows(IllegalArgumentException.class, () -> {
            SearchCriteria.createByContributor(null);
        });
    }

    @Test
    public void testInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            SearchCriteria.createByBoth(null, "Band1");
        });
    }
}