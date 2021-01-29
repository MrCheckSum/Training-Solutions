package ioreader.states;

public class State {
    private final String stateName;
    private final String capital;

    public String getStateName() {
        return stateName;
    }

    public String getCapital() {
        return capital;
    }

    private void checkParams(String stateName, String capital) {
        if (stateName == null || stateName.isBlank()) {
            throw new IllegalArgumentException("StateName is null! " + stateName);
        }
        if (stateName == null || stateName.isBlank()) {
            throw new IllegalArgumentException("Capital is null! " + capital);
        }
    }



    public State(String stateName, String capital) {
        this.stateName = stateName;
        this.capital = capital;
    }
}
