package controlselection.accents;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WithoutAccentsTest {


    @Test
    public void testWith() {
        Assertions.assertEquals('a', new WithOutAccents().convertToWithOutAccentChar('á'));
        Assertions.assertEquals('e', new WithOutAccents().convertToWithOutAccentChar('é'));
        Assertions.assertEquals('i', new WithOutAccents().convertToWithOutAccentChar('í'));
        Assertions.assertEquals('o', new WithOutAccents().convertToWithOutAccentChar('ó'));
        Assertions.assertEquals('u', new WithOutAccents().convertToWithOutAccentChar('ű'));

    }

    @Test
    public void testWithout(){
        Assertions.assertEquals('a', new WithOutAccents().convertToWithOutAccentChar('a'));
        Assertions.assertEquals('w', new WithOutAccents().convertToWithOutAccentChar('w'));
        Assertions.assertEquals('d', new WithOutAccents().convertToWithOutAccentChar('d'));
    }
}
