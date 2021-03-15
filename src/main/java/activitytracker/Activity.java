package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {

    private long id;
    private LocalDateTime startTime;
    private String desc;
    private ActivityType activityType;
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public Activity(LocalDateTime startTime, String desc, ActivityType activityType) {
        this.startTime = startTime;
        this.desc = desc;
        this.activityType = activityType;
    }

    public Activity(long id, LocalDateTime startTime, String desc, ActivityType activityType) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.activityType = activityType;
    }

    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public void addTrackPoints(List<TrackPoint> trackPoints) {
        this.trackPoints.addAll(trackPoints);
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", desc='" + desc + '\'' +
                ", activityType=" + activityType +
                ", trackPoints=" + trackPoints +
                '}';
    }
}
