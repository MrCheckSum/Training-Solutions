package week06d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ListSelectorTest {

    ListSelector listSelector = new ListSelector();

    @Test
    public void getElemenets() {

        Assertions.assertEquals("[13]", listSelector.getElements(Arrays.asList("1", "2", "3", "4")));
    }

    @Test
    public void getElementsWithNull () {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> listSelector.getElements(null));
    }

    @Test
    public void getElemenetsWithEmptyList(){
        Assertions.assertEquals("",listSelector.getElements(new ArrayList<>()));
    }
}
