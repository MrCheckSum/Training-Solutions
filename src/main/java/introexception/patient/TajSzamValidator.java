package introexception.patient;

public class TajSzamValidator {

    public boolean isValidTajNr(String taj) {
        if (taj.length() != 9)
            return false;

        try {
            int sum = 0;
            for (int i = 0; i < taj.length() - 1; i += 2) {
                sum += getAnIntFromChar(taj.charAt(i)) * 3;
            }
            for (int i = 1; i < taj.length() - 1; i += 2) {
                sum += getAnIntFromChar(taj.charAt(i)) * 7;
            }
            return (getAnIntFromChar(taj.charAt(8)) == (sum % 10));

        } catch
            (IllegalArgumentException iae){
                return false;
             }
    }

    private int getAnIntFromChar(char chr) {
        if (chr < '0' || chr > '9') throw new IllegalArgumentException("Csak számokból állhat!");
        return chr - '0';
    }
}
