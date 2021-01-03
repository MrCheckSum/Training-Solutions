package week08d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringListTest {

    @Test
    public void unionTest() {
        List<String> first = Arrays.asList("a", "b", "c");
        List<String> second = Arrays.asList("a", "d");
        StringList stringList = new StringList();
        Assertions.assertEquals(Arrays.asList("a", "b", "c", "d"), stringList.stringListUnion(first, second));

    }
}
