package methodchain;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private int distance;
    private int azimut;
    public List<NavigationPoint> navigationPoint = new ArrayList<>();

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public List<NavigationPoint> getNavigationPoint() {
        return navigationPoint;
    }

    public Robot go(int meter) {
        this.distance = this.distance + meter;
        return this;
    }

    public Robot rotate(int angle) {
        this.azimut = angle;
        return this;
    }

    public Robot registerNavigationPoint(){
        this.navigationPoint.add(new NavigationPoint(this.distance, this.azimut));
        return this;
    }

}
