package activity;

public class TrackPoint {

    private Coordinate coordinate;

    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }

    public double getDistanceFrom(TrackPoint trackPoint) {

        final int radiusOfEarth = 6371;
        final double thisLatitiude = coordinate.getLatitude(); // ugyan az, mint this.getCoordinate().getLatitude()
        final double thisLongitude = coordinate.getLongitude();
        final double otherLatitude = trackPoint.getCoordinate().getLatitude();
        final double otherLongitude = trackPoint.getCoordinate().getLongitude();

        Double latitudeDistance = Math.toRadians(otherLatitude - thisLatitiude);
        Double longitudeDistance = Math.toRadians(otherLongitude - thisLongitude);
        Double a = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2) + Math.cos(Math.toRadians(thisLatitiude))
                * Math.cos(Math.toRadians(otherLatitude)) * Math.sin(longitudeDistance / 2) * Math.sin(longitudeDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = radiusOfEarth * c * 1000;
        double height = this.getElevation() - trackPoint.getElevation();

        distance = Math.pow(distance, 2) + Math.pow(height, 2);
        return Math.sqrt(distance);
    }
}

