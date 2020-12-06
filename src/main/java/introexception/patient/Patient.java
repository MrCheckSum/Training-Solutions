package introexception.patient;

public class Patient {

    public static final int MIN_YEAR = 1900;

    private String name;
    private String tajNr;
    private int yearOfBirth;

    public Patient(String name, String tajNr, int yearOfBirth) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Név nincs megadva!");

        }
        if (yearOfBirth <= MIN_YEAR) {
            throw new IllegalArgumentException("Helytelen születési év! (" + yearOfBirth + ")");
        }
        if (!new TajSzamValidator().isValidTajNr(tajNr)) throw new IllegalArgumentException("Helytelen TAJ szám!");
        this.name = name;
        this.tajNr = tajNr;
        this.yearOfBirth = yearOfBirth;

    }

    public String getName() {
        return name;
    }

    public String getTajNr() {
        return tajNr;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
