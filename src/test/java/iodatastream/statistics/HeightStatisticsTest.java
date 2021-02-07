package iodatastream.statistics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeightStatisticsTest {

    @TempDir
    public File folder;

    @Test
    void saveHeights() throws IOException {
        File file = new File(folder, "test.txt");
        Path path = file.toPath();
        HeightStatistics heightStatistics = new HeightStatistics();

        List<Integer> heights = List.of(198, 201, 211, 195, 214, 208, 203, 198);
        heightStatistics.saveHeights(heights, path);

        byte[] original = this.getClass().getResourceAsStream("/statistics.dat").readAllBytes();
        byte[] savedfile = Files.readAllBytes(path);

        assertArrayEquals(original, savedfile);
    }
}