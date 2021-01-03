package week08d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {

    @Test
    public void testRobotMoves() {
        Robot robot = new Robot();
        robot.move("FFLLLLLBBBBJJJJJJJ");
        Assertions.assertEquals(3, robot.getPosition().getX());
        Assertions.assertEquals(-3, robot.getPosition().getY());
    }

    @Test
    public void testWrongRobotMoves(){
        Robot robot= new Robot();
        Assertions.assertThrows(IllegalArgumentException.class, ()->robot.move("FFD"));
    }
}
