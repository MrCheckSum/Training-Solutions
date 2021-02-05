package ioreadbytes.bytematrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    Matrix matrix = new Matrix();

    @Test
    void readFileAndCreateMatrix() {
        assertEquals(0, matrix.getMatrix().size());
        matrix.readFileAndCreateMatrix("matrix.dat");
        assertEquals(9, matrix.getMatrix().size());
        assertEquals(1000, matrix.getMatrix().get(5).length);
    }

    @Test
    void nrOfColumnsWithMoreNullasThanOnes() {
        matrix.readFileAndCreateMatrix("matrix.dat");
        assertEquals(493, matrix.nrOfColumnsWhereMoreNullaThanOne());
    }
}