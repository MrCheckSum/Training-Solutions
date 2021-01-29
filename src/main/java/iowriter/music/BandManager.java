package iowriter.music;

import xtest.A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path file) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataInLines = line.split(";");
                Band band = new Band(dataInLines[0], Integer.parseInt(dataInLines[1]));
                bands.add(band);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }

    private List<Band> olderThan(int year) {
        List<Band> result = new ArrayList<>();

        for (Band band : bands) {
            if (band.getYear() < year) {
                result.add(band);
            }
        }
        return result;
    }

    public void writeBandsBefore(Path fileToWrite, int year) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(fileToWrite)) {
            for (Band band : olderThan(year)) {
                bufferedWriter.write(band.getName() + " " + band.getYear() + "\n");
            }
        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }

}
