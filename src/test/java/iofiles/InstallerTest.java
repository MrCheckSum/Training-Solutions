package iofiles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class InstallerTest {
    @TempDir
    public File folder;

    @Test
    void install() {
        String targetDir = folder.getPath();

        Installer installer = new Installer();

        installer.install(targetDir);

        Path targetPath = folder.toPath();

        assertTrue(Files.exists(targetPath.resolve("bin")));
        assertTrue(Files.exists(targetPath.resolve("data")));
        assertTrue(Files.exists(targetPath.resolve("bin/binfile.txt")));
        assertTrue(Files.exists(targetPath.resolve("data/data1.dat")));
        assertTrue(Files.exists(targetPath.resolve("data/data2.dat")));
    }

    @Test
    public void testInstallWithFileTarget() throws IOException {
        String target = new File(folder, "test.txt").getPath();


        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Installer().install(target));
        assertEquals("Directory does not exist!", ex.getMessage());
    }
}