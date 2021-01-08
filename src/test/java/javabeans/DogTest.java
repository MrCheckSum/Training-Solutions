package javabeans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void setName() {
        final String name = "Döme";
        Dog dog = new Dog();
        dog.setName(name);

        assertEquals("Döme", dog.getName());
    }

    @Test
    void setAge() {
        final int age = 1;
        Dog dog  = new Dog();
        dog.setAge(age);
        assertEquals(1, dog.getAge());
    }

    @Test
    void setPedigree() {
        final boolean pedigree = true;
        Dog dog = new Dog();
        dog.setPedigree(pedigree);
        assertEquals(true,dog.isPedigree());
    }

    @Test
    void setWeight() {
        final double weight = 10.0;
        Dog dog = new Dog();
        dog.setWeight(weight);
        assertEquals(10.0,dog.getWeight());
    }
}