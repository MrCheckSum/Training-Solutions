package week09d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testPresentRelatedAge() {
        Person person1 = new Person("John", 13);
        Person person2 = new Person("Jane", 17);

        person1.setPresent();
        person2.setPresent();

        Assertions.assertNotEquals(null, person1.getPresent());
        Assertions.assertNotEquals(Present.TOY, person2.getPresent());

    }

}
