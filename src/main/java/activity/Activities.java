package activity;

import xtest.A;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities; // private List<Activity> activities = new ArrayList<>(); lenne, de felesleges mert a constructorban felülírjuk egy másik listával

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public int numberOfTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (activity.hasTrack()) {
                // if(activity instanceof ActivityWithTrack){ -al is lehet, de kerüljük az instanceof-ot lehetőleg (valami hibára utal)
                // interface-ben létrehoztuk a hasTracket, majd implementáltuk a With és WithoutTrack Activity osztályokban
                counter++;
            }
        }
        return counter;
    }

    public int numberOfWithoutTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (!activity.hasTrack()) {
                counter++;
            }
        }
        return counter;
    }

    public List<Report> distancesByTypes() {
        double[] sum = new double[ActivityType.values().length];
        for (Activity activity : activities) {
            sum[activity.getType().ordinal()] += activity.getDistance();
        }
        List<Report> result = new ArrayList<>();
        for (ActivityType activityType : ActivityType.values()) {
            new Report(activityType, sum[activityType.ordinal()]);
        }
        return result;
    }
}
