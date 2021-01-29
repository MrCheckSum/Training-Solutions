package ioreader.states;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateRegisterTest {

    private StateRegister stateRegister = new StateRegister();


    @Test
    public void testGetStates() {
        assertEquals(0, stateRegister.getStates().size());
        stateRegister.getStates().add(new State("Tennessee", "Nashville"));
        assertEquals(0, stateRegister.getStates().size());
    }


    @Test
    public void testWithWrongFileName() {
        Exception ex = assertThrows(IllegalStateException.class, () -> stateRegister.readStatesFromFile("NonReadFile.txt"));
        assertEquals("File is non-readable!", ex.getMessage());
    }

    @Test
    public void testReadFile() {
        assertEquals(0, stateRegister.getStates().size());

        stateRegister.readStatesFromFile("src/main/resources/stateregister.txt");

        assertEquals(50, stateRegister.getStates().size());
        assertEquals("Alabama", stateRegister.getStates().get(0).getStateName());
    }


    @Test
    public void wrongStateNameTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            stateRegister.readStatesFromFile("src/main/resources/stateregister.txt");
            stateRegister.findCapitalByStateName("Xstate");
        });
        assertEquals("No state name!", ex.getMessage());
    }

    @Test
    public void findCapitalByStateNameTest() {
        stateRegister.readStatesFromFile("src/main/resources/stateregister.txt");

        assertEquals("Topeka", stateRegister.findCapitalByStateName("Kansas"));
        assertEquals("Honolulu", stateRegister.findCapitalByStateName("Hawaii"));

    }

}