package statemachine.elevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorTest {

    @Test
    public void goUp() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.pushButtonToGoToFirstFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertEquals("[Ground Floor_Door Open, Ground Floor_Door Closed, First Floor_Door Closed, First Floor_Door Open]", actualStateInfo);
    }

    @Test
    public void goUpAndDown() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.pushButtonToGoToFirstFloor();
        elevator.work();
        elevator.pushButtonToGoToGroundFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertEquals("[Ground Floor_Door Open, Ground Floor_Door Closed, First Floor_Door Closed, First Floor_Door Open, First Floor_Door Closed, Ground Floor_Door Closed, Ground Floor_Door Open]", actualStateInfo);
    }

    @Test
    public void goUpAndCallDown() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.pushButtonToGoToFirstFloor();
        elevator.work();
        elevator.pushCallButtonOnGroundFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertEquals("[Ground Floor_Door Open, Ground Floor_Door Closed, First Floor_Door Closed, First Floor_Door Open, First Floor_Door Closed, Ground Floor_Door Closed, Ground Floor_Door Open]", actualStateInfo);
    }

    @Test
    public void goDown() throws InterruptedException {
        Elevator elevator = new Elevator(new FirstFloorClosed());
        elevator.pushCallButtonOnFirstFloor();
        elevator.pushCallButtonOnGroundFloor();
        elevator.pushButtonToGoToGroundFloor();
        elevator.work();

        String actualStateInfo = elevator.getHistory();
        assertEquals("[First Floor_Door Closed, First Floor_Door Open, First Floor_Door Closed, Ground Floor_Door Closed, Ground Floor_Door Open]", actualStateInfo);
    }


}