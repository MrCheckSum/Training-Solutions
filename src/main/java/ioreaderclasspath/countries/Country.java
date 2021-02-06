package ioreaderclasspath.countries;

public class Country {

    private String name;

    private int nrOfNeighboringCountries;

    public Country(String name, int nrOfNeighboringCountries) {
        this.name = name;
        this.nrOfNeighboringCountries = nrOfNeighboringCountries;
    }

    public String getName() {
        return name;
    }

    public int getNrOfNeighboringCountries() {
        return nrOfNeighboringCountries;
    }
}
