package constructoroverloading.bus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTimeTest {

    @Test
    public void constructorTest2Parameters() {
        //Given
        SimpleTime time = new SimpleTime(11, 20);
        //Then
        assertEquals(11, time.getHours());
        assertEquals(20, time.getMinutes());
    }

    @Test
    public void constructorTest1Parameter() {
        //Given
        SimpleTime time = new SimpleTime(9);
        //Then
        assertEquals(9, time.getHours());
        assertEquals(0, time.getMinutes());
    }

    @Test
    public void constructorTestSimpleTimeParameter() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(8, 40));
        //Then
        assertEquals(8, time.getHours());
        assertEquals(40, time.getMinutes());
    }

    @Test
    public void differenceAfter() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(7, 30));
        SimpleTime anotherTime = new SimpleTime(new SimpleTime(8, 0));
        //Then
        assertEquals(-30, time.difference(anotherTime));
    }

    @Test
    public void differenceIfEqual() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(6, 55));
        SimpleTime anotherTime = new SimpleTime(new SimpleTime(6, 55));
        //Then
        assertEquals(0, time.difference(anotherTime));
    }

    @Test
    public void differenceEarlier() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(10, 0));
        SimpleTime anotherTime = new SimpleTime(new SimpleTime(20, 0));
        //Then
        assertEquals(-600, time.difference(anotherTime));
    }

    @Test
    public void toStringTest() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(10, 10));
        //Then
        assertEquals("10:10", time.toString());
    }

}