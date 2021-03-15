package exam03retake01;

import exam03.Histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    Map<String, Integer> owls = new HashMap<>();


    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=");
            String county = parts[0];
            Integer nrOfOwls = Integer.parseInt(parts[1]);
            owls.put(county, nrOfOwls);
        }
    }

    public int getNumberOfOwls(String county) {
        return owls.get(county);
    }

    public static void main(String[] args) {
        OwlCounter owlCounter = new OwlCounter();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(OwlCounter.class.getResourceAsStream("owls.txt")))) {
            owlCounter.readFromFile(reader);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file!");
        }
    }
}
