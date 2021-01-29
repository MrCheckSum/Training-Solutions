package ioreader.states;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    List<State> states = new ArrayList<>();


    private State createState(String stateName, String capital) {

        return new State(stateName, capital);

    }

    private FileReader createFileReader(String filePathInString) {
        try {
            File file = new File(filePathInString);
            FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
            return fileReader;
        } catch (IOException e) {
            throw new IllegalStateException("File is non-readable!", e);
        }
    }

    private void processLine(String line) {
        String[] stateData = line.split("-");
        states.add(createState(stateData[0], stateData[1]));
    }

    public State findStateByCapitalName(String capital) {
        for (State state : states) {
            if (state.getStateName().equals(capital)) {
                return state;
            }
        }
        throw new IllegalArgumentException("No state name!");
    }

    public String findCapitalByStateName(String stateName) {
        for (State state : states) {
            if (state.getStateName().equals(stateName)) {
                return state.getCapital();
            }
        }
        throw new IllegalArgumentException("No state name!");
    }

    public void readStatesFromFile(String stringFileName) {
        FileReader fileReader = createFileReader(stringFileName);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable: " + stringFileName, exception);
        }
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

}
