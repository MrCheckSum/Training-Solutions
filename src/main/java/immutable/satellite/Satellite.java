package immutable.satellite;

public class Satellite {

    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    private boolean isEmpty(String text) {
        return text == null || "".equals(text.trim());
    }

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("registerIdent is empty!");
        }
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    @Override
    public String toString() {
        return registerIdent + ": " + destinationCoordinates.toString();
    }

    public void modifyDestination(CelestialCoordinates diffence) {
        destinationCoordinates = new CelestialCoordinates(
                destinationCoordinates.getX() + diffence.getX(),
                destinationCoordinates.getY() + diffence.getY(),
                destinationCoordinates.getZ() + diffence.getZ());
    }

}
