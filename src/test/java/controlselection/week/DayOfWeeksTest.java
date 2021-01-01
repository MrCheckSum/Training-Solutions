package controlselection.week;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DayOfWeeksTest {

    @Test
    public void testWhichDay() {
        Assertions.assertEquals("hét eleje", new DayOfWeek().whichDay("hétfő"));
        Assertions.assertEquals("hét közepe", new DayOfWeek().whichDay("Szerda"));
        Assertions.assertEquals("majdnem hétvége", new DayOfWeek().whichDay("péntek"));
        Assertions.assertEquals("hét vége", new DayOfWeek().whichDay("szombat"));
    }

    @Test
    public void testCase(){
        Assertions.assertEquals("hét közepe", new DayOfWeek().whichDay("kEDd"));
    }

    @Test
    public void testIllegalCase(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->new DayOfWeek().whichDay("yxcyx"));
    }
}
