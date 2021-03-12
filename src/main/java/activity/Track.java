package activity;

import xtest.C;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate() {
        if (trackPoints.isEmpty()) {
            throw new IllegalArgumentException("No trackpoints!");
        }

        double maxLatitide = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLongitude = trackPoints.get(0).getCoordinate().getLongitude();

        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() > maxLatitide) {
                maxLatitide = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLatitide, maxLongitude);
    }

    public Coordinate findMinimumCoordinate() {
        if (trackPoints.isEmpty()) {
            throw new IllegalArgumentException("No trackpoints!");
        }

        double minLatitide = trackPoints.get(0).getCoordinate().getLatitude();
        double minLongitude = trackPoints.get(0).getCoordinate().getLongitude();

        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() < minLatitide) {
                minLatitide = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() < minLongitude) {
                minLongitude = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLatitide, minLongitude);
    }

    public double getRectangleArea() {
        Coordinate min = findMinimumCoordinate();
        Coordinate max = findMaximumCoordinate();

        return max.getLatitude() - min.getLatitude() * max.getLongitude() - min.getLongitude();
    }

    public double getFullElevation() {
        double elevationSum = 0;

        for (int i = 0; i < trackPoints.size() - 1; i++) {
            TrackPoint actualTrackPoint = trackPoints.get(i);
            TrackPoint nextTrackPoint = trackPoints.get(i + 1);
            if (actualTrackPoint.getElevation() < nextTrackPoint.getElevation()) {
                elevationSum += Math.abs(actualTrackPoint.getElevation() - nextTrackPoint.getElevation());
            }
        }
        return elevationSum;
    }

    public double getFullDecrease() {
        double decreaseSum = 0;

        for (int i = 0; i < trackPoints.size() - 1; i++) {
            TrackPoint actualTrackPoint = trackPoints.get(i);
            TrackPoint nextTrackPoint = trackPoints.get(i + 1);
            if (actualTrackPoint.getElevation() > nextTrackPoint.getElevation()) {
                decreaseSum += Math.abs(actualTrackPoint.getElevation() - nextTrackPoint.getElevation());
            }
        }
        return decreaseSum;
    }

    public double getDistance() {
        double sum = 0;
        TrackPoint previousTrack = trackPoints.get(0);
        for (TrackPoint actualTrack : trackPoints) {
            sum += previousTrack.getDistanceFrom(actualTrack);
            previousTrack = actualTrack;
        }
        return sum;
    }
}