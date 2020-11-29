package week05d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCounterTest {

    @Test
    public void startWithATest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = Arrays.asList("alma", "körte", "banán", "kiwi", "eper");

        Assertions.assertEquals(1, listCounter.startsWithACounter(testList));
    }

    @Test
    public void startsWithEmptyListTest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = new ArrayList<>();

        Assertions.assertEquals(0, listCounter.startsWithACounter(testList));

    }

    @Test
    public void startsWithNonAListTest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = Arrays.asList("körte", "banán", "kiwi", "eper");

        Assertions.assertEquals(0, listCounter.startsWithACounter(testList));

    }

}