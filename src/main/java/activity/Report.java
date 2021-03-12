package activity;

public class Report {

    private ActivityType activityType; // final is lehet mivel immutable

    private  double distance; // final is lehet mivel immutable

    public Report(ActivityType activityType, double distance) {
        this.activityType = activityType;
        this.distance = distance;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public double getDistance() {
        return distance;
    }
}
