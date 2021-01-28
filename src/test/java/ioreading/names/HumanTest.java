package ioreading.names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    private Human human = new Human("John", "Doe");

    @Test
    void createHumanTest() {
        assertEquals("John", human.getFirstName());
        assertEquals("Doe", human.getLastName());
    }

    }