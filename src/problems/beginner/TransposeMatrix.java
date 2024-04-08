package problems.beginner;

import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            // Transpose the matrix if it is not a square matrix
            int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    transposedMatrix[j][i] = matrix[i][j];
                }
            }
            return transposedMatrix;
        } else {
            // Transpose the matrix in-place if it is a square matrix
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix[0].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return matrix;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Transposed matrix:");
        int[][] tMatrix = transpose(matrix);
        for (int[] row : tMatrix) {
            System.out.println(Arrays.toString(row));
        }

    }
}
