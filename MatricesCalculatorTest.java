package Ejercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatricesCalculatorTest {

    @Test
    void testCalculateMatrixB() {
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixC = {{5, 6}, {7, 8}};
        int[][] expectedMatrixB = {{4, 4}, {4, 4}};

        int[][] actualMatrixB = MatricesCalculator.calculateMatrixB(matrixA, matrixC);

        assertArrayEquals(expectedMatrixB, actualMatrixB);
    }
    
    @Test
    public void testCalculateMatrixB1() {
    	 int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
         int[][] matrixC = {{7, 8, 9}, {10, 11, 12}};
         int[][] expectedMatrixB = {{6, 6, 6}, {6, 6, 6}};

         int[][] actualMatrixB = MatricesCalculator.calculateMatrixB(matrixA, matrixC);
        
         assertArrayEquals(expectedMatrixB, actualMatrixB);
    }
}

