package javabeans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void setName() {
        final String name = "Demeter";
        Human human = new Human();
        human.setName(name);
        assertEquals("Demeter",human.getName());
    }

    @Test
    void setWeight() {
        final double weight = 82.3;
        Human human = new Human();
        human.setWeight(weight);
        assertEquals(82.3,human.getWeight());
    }

    @Test
    void setIq() {
        final int iq = 150;
        Human human= new Human();
        human.setIq(iq);
        assertEquals(150, human.getIq());
    }
}