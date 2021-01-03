package week09d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SantaClausTest {

    private static final List<Person> people = Arrays.asList(
            new Person("John", 7),
            new Person("Jane", 13),
            new Person("Jack", 20));


    @Test
    void testSantaClaus() {
        SantaClaus santaClaus = new SantaClaus(people);
        santaClaus.getThroughChimneys();
        System.out.println(santaClaus.getPeople());

    }

}