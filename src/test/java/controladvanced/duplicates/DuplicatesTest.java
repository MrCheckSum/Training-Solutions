package controladvanced.duplicates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DuplicatesTest {

    @Test
    public void findDuplicates() {
        Assertions.assertEquals(Arrays.asList(), new Duplicates().find(Arrays.asList()));
        Assertions.assertEquals(Arrays.asList(), new Duplicates().find(Arrays.asList(1, 2, 3)));
        Assertions.assertEquals(Arrays.asList(2), new Duplicates().find(Arrays.asList(1, 2, 2, 3)));
        Assertions.assertEquals(Arrays.asList(2, 3), new Duplicates().find(Arrays.asList(1, 2, 3, 3, 3, 4)));
        Assertions.assertEquals(Arrays.asList(3, 3), new Duplicates().find(Arrays.asList(1, 2, 3, 3, 3, 4)));
        Assertions.assertEquals(Arrays.asList(2, 3, 3), new Duplicates().find(Arrays.asList(1, 2, 2, 3, 3, 3, 4)));
    }
}
