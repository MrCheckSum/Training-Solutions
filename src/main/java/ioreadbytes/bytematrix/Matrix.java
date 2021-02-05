package ioreadbytes.bytematrix;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private List<byte[]> matrix = new ArrayList<>();

    public void readFileAndCreateMatrix(String fileName) {
        Path path = Path.of(fileName);
        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] bytes = new byte[1000];
            int size = 0;
            while ((size = inputStream.read(bytes)) > 0) {
                matrix.add(bytes);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Fiel is non-readable!", ioException);
        }
    }

    public int nrOfColumnsWhereMoreNullaThanOne() {
        int nrOfColumns = 0;
        for (int i = 0; i < 1000; i++) {
            int nullas = 0;
            int ones = 0;

            for (int j = 0; j < matrix.size(); j++) {
                if (matrix.get(j)[i] == 48) {
                    nullas++;
                } else {
                    ones++;
                }
            }
            if (nullas > ones) {
                nrOfColumns++;
            }
        }
        return nrOfColumns;
    }

    public List<byte[]> getMatrix() {
        return new ArrayList<>(matrix);
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.readFileAndCreateMatrix("matrix.dat");
        System.out.println(matrix.nrOfColumnsWhereMoreNullaThanOne());
    }
}