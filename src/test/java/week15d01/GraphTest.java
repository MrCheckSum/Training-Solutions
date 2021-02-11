package week15d01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void TestExepciton() {
        Graph graph = new Graph();

        Map<Double, Double> graphPoints = new HashMap<>();
        System.out.println(graphPoints.size());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.findMaxEntryValue(graphPoints));
        assertEquals("Illegal parameter!", exception.getMessage());

    }

    @Test
    void findMaxEntryValue() {

        Graph graph = new Graph();

        Map<Double, Double> graphPoints = new HashMap<>();

        graphPoints.put(-10.0, 6.0);
        graphPoints.put(-3.4, 5.0);
        graphPoints.put(1.0, 4.3);
        graphPoints.put(8.0, -1.0);

        Map.Entry<Double, Double> result = graph.findMaxEntryValue(graphPoints);

        assertEquals(-10.0, result.getKey());
        assertEquals(6.0, result.getValue());
    }
}