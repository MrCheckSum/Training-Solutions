package methodchain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    private Robot robot;

    @BeforeEach
    public void setUp(){
        this.robot=new Robot();
    }

    @AfterEach
    public void tearDown(){
        this.robot = null;
    }

    @Test
    public void go() {
        //When
        robot.go(10).go(5).go(20);
        //Then
        assertEquals(35,robot.getDistance());
    }

    @Test
    void rotate() {
        //When
        robot.rotate(20).rotate(15).rotate(10);
        //Then
        assertEquals(10, robot.getAzimut());
    }

    @Test
    void registerNavigationPoint() {
        //When
        robot.go(10).rotate(10).registerNavigationPoint().go(20).rotate(-5).registerNavigationPoint();
        //Then
        assertEquals("[distance: 10 azimut: 10, distance: 30 azimut: -5]", robot.getNavigationPoint().toString());
    }
}