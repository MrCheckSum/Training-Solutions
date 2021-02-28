package interfaces.simplethread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleThreadTest {

    @Test
    public void runWithEmptyTasks() {
        List<String> tasks = new ArrayList<>();
        SimpleThread simpleThread = new SimpleThread(tasks);
        assertEquals(0, simpleThread.getTasks().size());

        simpleThread.run();

        assertEquals(0, simpleThread.getTasks().size());
    }

    @Test
    public void runWithTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("olvas");
        tasks.add("takarít");
        tasks.add("bevásárol");
        SimpleThread simpleThread = new SimpleThread(tasks);
        assertEquals(tasks.size(), simpleThread.getTasks().size());

        simpleThread.run();

        assertEquals(0, simpleThread.getTasks().size());
    }

}