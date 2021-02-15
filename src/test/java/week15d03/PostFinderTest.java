package week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void findPost() {
        PostFinder postFinder = new PostFinder(Arrays.asList(
                new Post("Title1", LocalDate.of(2021,2,5), "Content1", "Owner1"),
                new Post("Title1", LocalDate.of(2025,2,5), "Content1", "Owner1"),
                new Post("Title2", LocalDate.of(2021,2,5), "Content2", "Owner2"),
                new Post(null, null, null, null)
        ));
        assertEquals("Title1", postFinder.findPostFor("Owner1").toString());
        assertEquals("", postFinder.findPostFor(null));


    }
}