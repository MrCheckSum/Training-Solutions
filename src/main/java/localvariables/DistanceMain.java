package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance();
        System.out.println("Távolság:" + distance.getDistance() + " Pontos:" + distance.isExactDistance());

        int wholeNrOfDistance = (int) distance.getDistance();
        System.out.println("A távolság egész része: " + wholeNrOfDistance);
    }
}
