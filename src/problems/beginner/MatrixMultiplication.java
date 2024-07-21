package problems.beginner;

public class MatrixMultiplication {
    static int[][] matMul(int[][] mat1, int[][] mat2) {
        int r1 = mat1.length;
        int r2 = mat2.length;
        int c1 = mat1[0].length;
        int c2 = mat2[0].length;

        if (c1 != r2)
            throw new IllegalArgumentException("Matrix multiplication not possible");

        int[][] product = new int[r1][c2];

        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    product[i][j] += mat1[i][k] * mat2[k][j];

        return product;
    }


    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] mat2 = {
                {-1, 0, 0},
                {0, -1, 0},
                {0, 0, -1}
        };

        int[][] product = matMul(mat1, mat2);

        for (int[] row : product) {
            for (int cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
    }
}
