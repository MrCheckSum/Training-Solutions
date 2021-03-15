package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;

    @BeforeEach
    public void init() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection not established", sqlException);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

// Flyway configurálása
//        Flyway flyway = Flyway.configure()
//                .locations("db/migration/activitytracker")
//                .dataSource(activityDao.getDataSource())
//                .load();

        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    public void insertElementTest() {
        Activity activity = new Activity(LocalDateTime.of(2021, 2, 23, 10, 11), "Biking in Zemplén", ActivityType.BIKING);
        activityDao.insertActivity(activity);

        assertEquals(activityDao.selectAllActivities().size(), 4);
    }

    @Test
    public void selectByType() {
        assertEquals(activityDao.selectActivitiesByType(ActivityType.BIKING).size(), 1);
    }

    @Test
    public void selectByDateBefore() {
        assertEquals(activityDao.activitiesBeforeDate(LocalDate.of(2021, 2, 2)).size(), 3);
    }

    @Test
    public void findByIdTest() {
        Activity activity = new Activity(LocalDateTime.now(), "Biking in Mecsek", ActivityType.BIKING);
        Activity result = activityDao.insertActivity(activity);
        assertEquals(activity.getDesc(), activityDao.selectById(result.getId()).getDesc());
    }

    @Test
    public void insertActivityWithTrackPointsTest() {
        Activity activity = new Activity(LocalDateTime.now(), "Biking in Mecsek", ActivityType.BIKING);
        activity.addTrackPoints(List.of(
                new TrackPoint(LocalDate.of(2021, 2, 23), 67, 23),
                new TrackPoint(LocalDate.of(2021, 2, 23), 68, 22),
                new TrackPoint(LocalDate.of(2021, 2, 23), 68, 21)));

        Activity ac = activityDao.insertActivity(activity);

        System.out.println(activityDao.selectById(ac.getId()));
    }
}