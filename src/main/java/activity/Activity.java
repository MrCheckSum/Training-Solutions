package activity;

public interface Activity {

    double getDistance();

    public ActivityType getType();

    boolean hasTrack();

    //deafault boolean hasTrack() { return false} - ezzel elkerülhető, hogy implementálni kelljen a ActivityWithoutTrack osztályban, mivel default-ként false-al tér vissza

}
