package Ejercicio1;

import java.io.*;

public class MatricesCalculator {
    public static void main(String[] args) {
        // Rutas de los archivos de entrada y salida
        String matrixAFile = "matrixA.txt";
        String matrixCFile = "matrixC.txt";
        String matrixBFile = "matrixB.txt";

        // Leer matrices A y C desde los archivos
        int[][] matrixA = readMatrixFromFile(matrixAFile);
        int[][] matrixC = readMatrixFromFile(matrixCFile);

        // Verificar si las dimensiones de las matrices son válidas
        if (matrixA.length != matrixC.length || matrixA[0].length != matrixC[0].length) {
            System.out.println("Las dimensiones de las matrices no coinciden.");
            return;
        }

        // Calcular la matriz B
        int[][] matrixB = calculateMatrixB(matrixA, matrixC);

        // Escribir la matriz B en el archivo de salida
        writeMatrixToFile(matrixB, matrixBFile);

        System.out.println("La matriz B ha sido calculada y escrita en el archivo " + matrixBFile);
    }

    // Método para leer una matriz desde un archivo
    private static int[][] readMatrixFromFile(String fileName) {
        int[][] matrix = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Leer las dimensiones de la matriz
            String line = reader.readLine();
            String[] dimensions = line.split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);

            // Crear la matriz
            matrix = new int[rows][cols];

            // Leer los elementos de la matriz
            for (int i = 0; i < rows; i++) {
                line = reader.readLine();
                String[] elements = line.split(" ");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrix;
    }

    // Método para calcular la matriz B a partir de las matrices A y C
    static int[][] calculateMatrixB(int[][] matrixA, int[][] matrixC) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] matrixB = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = matrixC[i][j] - matrixA[i][j];
            }
        }

        return matrixB;
    }

    // Método para escribir una matriz en un archivo
    private static void writeMatrixToFile(int[][] matrix, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            // Escribir las dimensiones de la matriz en la primera línea
            int rows = matrix.length;
            int cols = matrix[0].length;
            writer.write(rows + " " + cols);
            writer.newLine();

            // Escribir los elementos de la matriz en líneas separadas
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    writer.write(matrix[i][j] + " ");
                }
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

