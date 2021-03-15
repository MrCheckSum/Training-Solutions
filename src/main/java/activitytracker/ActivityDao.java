package activitytracker;

import com.sun.source.tree.TryTree;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Activity insertActivity(Activity activity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            preparedStatement.setString(2, activity.getDesc());
            preparedStatement.setString(3, activity.getActivityType().toString());
            preparedStatement.executeUpdate();
            Activity result = getIdFromStatement(activity, preparedStatement);
            insertActivityTrackPoints(activity.getTrackPoints(), result.getId());
            return getIdFromStatement(activity, preparedStatement);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

    private void insertActivityTrackPoints(List<TrackPoint> trackPoints, long activityId) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (
                    PreparedStatement stmt = conn.prepareStatement("insert into track_points(act_time, lat, lon, activityid) values (?,?,?,?)")) {
                for (TrackPoint trackPoint : trackPoints) {
                    if (!isValidLatLon(trackPoint.getLat(), trackPoint.getLon())) {
                        throw new IllegalArgumentException("Invalid lat or lon!");
                    }
                    stmt.setDate(1, Date.valueOf(trackPoint.getTime()));
                    stmt.setDouble(2, trackPoint.getLat());
                    stmt.setDouble(3, trackPoint.getLon());
                    stmt.setLong(4, activityId);
                    stmt.executeUpdate();
                }
                conn.commit();
            } catch (IllegalArgumentException illegalArgumentException) {
                conn.rollback();
                throw new IllegalArgumentException("Transaction failed!");
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect!", sqlException);
        }
    }

    private boolean isValidLatLon(double lat, double lon) {
        if (lat > 90 || lat < -90) {
            return false;
        }
        if (lon > 180 || lon < -180) {
            return false;
        }
        return true;
    }

    private Activity getIdFromStatement(Activity activity, PreparedStatement preparedStatement) throws SQLException {
        try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
            if (rs.next()) {
                long id = rs.getLong(1);
                return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getActivityType());
            }
        }
        throw new IllegalStateException("Cannot get key!");
    }

    public String createStatementForMoreInsert(int numberOfElements) {
        StringBuilder sb = new StringBuilder("insert into activities(start_time. activity_desc, activity_type) values");
        for (int i = 0; i < numberOfElements; i++) {
            sb.append("(?,?,?)");
        }
        return sb.toString();
    }

    public Activity selectById(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement1 = connection.prepareStatement("select * from activities where id =?");
             PreparedStatement preparedStatement2 = connection.prepareStatement("select * from track_points where activityid =?")) {
            preparedStatement1.setLong(1, id);
            List<Activity> result = selectActivityByPreparedStatement(preparedStatement1);
            if (result.size() == 1) {
                preparedStatement2.setLong(1, id);
                List<TrackPoint> resultPoints = selectTrackPointByPreparedStatement(preparedStatement2);
                result.get(0).addTrackPoints(resultPoints);
                return result.get(0);
            }
            throw new IllegalArgumentException("not found!");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

    private List<Activity> selectActivityByPreparedStatement(PreparedStatement preparedStatement) {
        List<Activity> result = new ArrayList<>();
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Activity activity = new Activity(rs.getLong("id"), rs.getTimestamp("start_time").toLocalDateTime(), rs.getString("activity_desc"), ActivityType.valueOf(rs.getString("activity_type")));
                result.add(activity);
            }
            return result;
        } catch (SQLException sqlException) {
            throw new IllegalArgumentException("Wrong statement", sqlException);
        }
    }

    private List<TrackPoint> selectTrackPointByPreparedStatement(PreparedStatement preparedStatement) {
        List<TrackPoint> result = new ArrayList<>();
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                TrackPoint trackPoint = new TrackPoint(rs.getLong("id"), rs.getDate("act_time").toLocalDate(), rs.getDouble("lat"), rs.getDouble("lon"));
                result.add(trackPoint);
            }
            return result;
        } catch (SQLException sqlException) {
            throw new IllegalArgumentException("Wrong statement", sqlException);
        }
    }

    public List<Activity> selectAllActivities() {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities")) {
            return selectActivityByPreparedStatement(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalArgumentException("Connection falied!", sqlException);
        }
    }

    public List<Activity> selectActivitiesByType(ActivityType type) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities where activity_type=?")) {
            stmt.setString(1, type.toString());
            return selectActivityByPreparedStatement(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }
    }

    public List<Activity> activitiesBeforeDate(LocalDate date) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities where start_time<?")) {
            LocalDateTime dateWithTime = date.atTime(0, 0, 0);
            stmt.setTimestamp(1, Timestamp.valueOf(dateWithTime));
            return selectActivityByPreparedStatement(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }
    }
}
