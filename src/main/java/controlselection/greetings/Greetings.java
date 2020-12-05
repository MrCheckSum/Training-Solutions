package controlselection.greetings;

public class Greetings {

    public static final int MINUTES = 60;

    public String greet(int hour, int minutes) {
        int timeInMinutes = hour * MINUTES + minutes;
        if (timeInMinutes <= 5 * MINUTES || timeInMinutes > 20 * MINUTES) {
            return "Jó éjt!";
        } else if (timeInMinutes > 5 * MINUTES && timeInMinutes <= 9 * MINUTES) {
            return "Jó reggelt!";
        } else if (timeInMinutes > 9 * MINUTES && timeInMinutes < 18 * MINUTES) {
            return "Jó napot!";
        } else {
            return "Jó estét!";
        }
    }
}
