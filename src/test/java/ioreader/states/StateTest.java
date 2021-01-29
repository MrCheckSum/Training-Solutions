package ioreader.states;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    private State state = new State("Montama", "Helena");

    @Test
    public void createState() {
        assertEquals("Montana", state.getStateName());
        assertEquals("Helena", state.getCapital());
    }

}
