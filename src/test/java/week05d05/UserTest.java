package week05d05;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void test() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User("Károly", "Kiss", "karoly.kisskisskft.hu");

        });
    }
}
